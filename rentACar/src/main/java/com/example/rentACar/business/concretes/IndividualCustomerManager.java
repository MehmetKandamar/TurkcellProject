package com.example.rentACar.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.IndividualCustomerService;
import com.example.rentACar.business.dtos.listDtos.ListIndividualCustomerDto;
import com.example.rentACar.business.requests.createRequests.CreateIndividualCustomerRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.ErrorDataResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessDataResult;
import com.example.rentACar.core.results.SuccessResult;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.IndividualCustomerDao;
import com.example.rentACar.entities.concretes.IndividualCustomer;

@Service
public class IndividualCustomerManager implements IndividualCustomerService{

	private IndividualCustomerDao individualCustomerDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public IndividualCustomerManager(IndividualCustomerDao individualCustomerDao, ModelMapperService modelMapperService) {
		this.individualCustomerDao = individualCustomerDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<ListIndividualCustomerDto>> getAll() {
		var result = this.individualCustomerDao.findAll();
		
		List<ListIndividualCustomerDto> response = result.stream()
				.map(customer -> this.modelMapperService.forDto().map(customer, ListIndividualCustomerDto.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<ListIndividualCustomerDto>>(response);

	}

	@Override
	public DataResult<ListIndividualCustomerDto> getAllByCustomerId(int customerId) {
		IndividualCustomer result = this.individualCustomerDao.getAllByCustomerId(customerId);
		
		if(result == null) {
			return new ErrorDataResult<ListIndividualCustomerDto>("Car.NotFound");
		}
		ListIndividualCustomerDto response = this.modelMapperService.forDto().map(result, ListIndividualCustomerDto.class);		
		
		return new SuccessDataResult<ListIndividualCustomerDto>(response);

	}

	@Override
	public Result create(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
		IndividualCustomer customer = this.modelMapperService.forRequest().map(createIndividualCustomerRequest, IndividualCustomer.class);
		customer.setRegistrationDate(LocalDate.now());
		customer.setCustomerId(0);
		this.individualCustomerDao.save(customer);
		
		
		return new SuccessResult("IndividualCustomer.Added");

	}

}
