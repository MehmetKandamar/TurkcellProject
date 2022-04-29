package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.InvoiceService;
import com.example.rentACar.business.constants.Messages;
import com.example.rentACar.business.dtos.listDtos.ListInvoiceDto;
import com.example.rentACar.business.requests.createRequests.CreateInvoiceRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteInvoiceRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateInvoiceRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessDataResult;
import com.example.rentACar.core.results.SuccessResult;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.InvoiceDao;
import com.example.rentACar.entities.concretes.Invoice;

@Service
public class InvoiceManager implements InvoiceService{
	private InvoiceDao invoiceDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public InvoiceManager(InvoiceDao invoiceDao, ModelMapperService modelMapperService) {
		this.invoiceDao = invoiceDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<ListInvoiceDto>> getAll() {
		var result = this.invoiceDao.findAll();
		List<ListInvoiceDto> response = result.stream()
				.map(brand -> this.modelMapperService.forDto().map(brand, ListInvoiceDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListInvoiceDto>>(response);
	}

	@Override
	public Result create(CreateInvoiceRequest createInvoiceRequest) {
		
		Invoice invoice = this.modelMapperService.forRequest().map(createInvoiceRequest, Invoice.class);
		this.invoiceDao.save(invoice);
		return new SuccessResult(Messages.InvoiceCreated);
	}

	@Override
	public Result delete(DeleteInvoiceRequest deleteInvoiceRequest) {
		
		Invoice invoice = this.modelMapperService.forRequest().map(deleteInvoiceRequest, Invoice.class);
		this.invoiceDao.delete(invoice);
		return new SuccessResult(Messages.InvoiceDeleted);
	}

	@Override
	public Result update(UpdateInvoiceRequest updateInvoiceRequest) {
		
		Invoice invoice = this.modelMapperService.forRequest().map(updateInvoiceRequest, Invoice.class);
		this.invoiceDao.save(invoice);
		return new SuccessResult(Messages.InvoiceUpdated);
	}


}
