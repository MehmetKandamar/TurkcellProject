package com.example.rentACar.business.concretes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.rentACar.api.models.CreatePaymentModel;
import com.example.rentACar.business.abstracts.AdditionalServiceService;
import com.example.rentACar.business.abstracts.CarService;
import com.example.rentACar.business.abstracts.CreditCardDetailsService;
import com.example.rentACar.business.abstracts.CustomerService;
import com.example.rentACar.business.abstracts.InvoiceService;
import com.example.rentACar.business.abstracts.OrderedAdditionalServiceService;
import com.example.rentACar.business.abstracts.PaymentService;
import com.example.rentACar.business.abstracts.RentalService;
import com.example.rentACar.business.constants.Messages;
import com.example.rentACar.business.dtos.getDtos.GetRentalDto;
import com.example.rentACar.business.dtos.listDtos.ListOrderedAdditionalServiceDto;
import com.example.rentACar.business.dtos.listDtos.ListPaymentDto;
import com.example.rentACar.business.requests.createRequests.CreateInvoiceRequest;
import com.example.rentACar.business.requests.createRequests.CreatePaymentRequest;
import com.example.rentACar.business.requests.deleteRequests.DeletePaymentRequest;
import com.example.rentACar.core.adapters.abstracts.BankAdapterService;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessDataResult;
import com.example.rentACar.core.results.SuccessResult;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.PaymentDao;
import com.example.rentACar.entities.concretes.Payment;
import com.example.rentACar.entities.concretes.Rental;

@Service
public class PaymentManager implements PaymentService{

	private ModelMapperService modelMapperService;
	private PaymentDao paymentDao;
	private RentalService rentalService;
	private BankAdapterService bankAdapterService;
	private CarService carService;
	private AdditionalServiceService additionalServiceService;
	private OrderedAdditionalServiceService orderedAdditionalServiceService;
	private CustomerService customerService;
	private InvoiceService invoiceService;
	private CreditCardDetailsService creditCardDetailsService;

	@Autowired
	public PaymentManager(ModelMapperService modelMapperService, PaymentDao paymentDao, RentalService rentalService,
			BankAdapterService bankAdapterService, CarService carService,
			AdditionalServiceService additionalServiceService,
			OrderedAdditionalServiceService orderedAdditionalServiceService,
			InvoiceService invoiceService,
			CreditCardDetailsService creditCardDetailsService,
			CustomerService customerService) {
		this.modelMapperService = modelMapperService;
		this.paymentDao = paymentDao;
		this.rentalService = rentalService;
		this.bankAdapterService = bankAdapterService;
		this.orderedAdditionalServiceService = orderedAdditionalServiceService;
		this.carService = carService;
		this.additionalServiceService = additionalServiceService;
		this.invoiceService = invoiceService;
		this.creditCardDetailsService = creditCardDetailsService;
		this.customerService = customerService;

	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
	public Result add(CreatePaymentModel createPaymentModel) throws BusinessException{

		// this.rentalService.checkRentCarExists(createPaymentRequest.getRentalId());

		GetRentalDto rental = this.modelMapperService.forRequest().map(createPaymentModel.getCreateRentalRequest(), GetRentalDto.class);

		double totalPrice = rentalCalculation(rental);

		this.bankAdapterService.checkIfLimitIsEnough(createPaymentModel.getCreatePaymentRequest(), totalPrice);
		Rental createdRental = this.rentalService.create(createPaymentModel.getCreateRentalRequest()).getData();
		CreateInvoiceRequest createInvoiceRequest = new CreateInvoiceRequest();
		createInvoiceRequest.setCreationDate(LocalDate.now());
		createInvoiceRequest.setInvoiceNumber(createPaymentModel.getInvoiceNumber());
		createInvoiceRequest.setCustomerId(createdRental.getCustomer().getCustomerId());
		createInvoiceRequest.setRentalId(createdRental.getRentalId());
		this.invoiceService.create(createInvoiceRequest);
		Payment payment = this.modelMapperService.forRequest().map(createPaymentModel.getCreatePaymentRequest(), Payment.class);
		payment.setPaymentAmount(totalPrice);;
		payment.setPaymentId(0);
		this.paymentDao.save(payment);
		

		return new SuccessResult();
	}

	@Override
	public Result delete(DeletePaymentRequest deletePaymentRequest) {

		checkPaymentExists(deletePaymentRequest.getPaymentId());

		Payment payment = this.modelMapperService.forRequest().map(deletePaymentRequest, Payment.class);
		this.paymentDao.deleteById(payment.getPaymentId());

		return new SuccessResult();
	}

	@Override
	public DataResult<List<ListPaymentDto>> getAll() {

		List<Payment> result = this.paymentDao.findAll();
		List<ListPaymentDto> response = result.stream()
				.map(payment -> this.modelMapperService.forDto().map(payment, ListPaymentDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ListPaymentDto>>(response);
	}

	@Override
	public DataResult<List<ListPaymentDto>> getAllPaged(int pageNo, int pageSize) {

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize); // Pageable, Sort gibi özellikleri org.springframework.data.domain'den import ederiz.

		List<Payment> result = this.paymentDao.findAll(pageable).getContent();
		List<ListPaymentDto> response = result.stream()
				.map(payment -> this.modelMapperService.forDto().map(payment, ListPaymentDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ListPaymentDto>>(response);
	}

	@Override
	public DataResult<ListPaymentDto> getByRentalId(int rentalId) {

		// this.rentalService.checkRentCarExists(rentalId);

		var result = this.paymentDao.getAllByRental_RentalId(rentalId);
		ListPaymentDto response = this.modelMapperService.forDto().map(result, ListPaymentDto.class);

		return new SuccessDataResult<ListPaymentDto>(response);
	}

	@Override
	public boolean checkPaymentRentalId(int rentalId) {

		var result = this.paymentDao.getAllByRental_RentalId(rentalId);
		if (result != null) {
			throw new BusinessException(Messages.PaymentIsReceivedInAdvance);
		}
		return true;
	}

	private boolean checkPaymentExists(int paymentId) {

		var result = this.paymentDao.existsById(paymentId);
		if (result) {
			return true;
		}
		throw new BusinessException(Messages.PaymentIdNotFound);
	}

	private double rentalCalculation(GetRentalDto rental) {

		double totalPrice = 0;

		List<ListOrderedAdditionalServiceDto> orderedAdditionalServiceDtos = orderedAdditionalServiceService
				.findAllByRentalId(rental.getCarId()).getData();

		if (orderedAdditionalServiceDtos.size() > 0) {
			for (ListOrderedAdditionalServiceDto orderedAdditionalServiceDto : orderedAdditionalServiceDtos) {
				totalPrice += additionalServiceService
						.findById(orderedAdditionalServiceDto.getOrderedAdditionalServiceId()).getData().getAdditionalServicePrice();
			}
		}

		if (rental.getInitialCityId() != rental.getReturnCityId())
			totalPrice += 750;

		long days = ChronoUnit.DAYS.between(rental.getRentDate(), rental.getReturnDate());

		if (days == 0)
			days = 1;

		totalPrice += days * carService.getById(rental.getCarId()).getData().getDailyPrice();

		return totalPrice;
	}

}
