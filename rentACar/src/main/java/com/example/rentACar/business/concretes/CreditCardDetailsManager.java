package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.CreditCardDetailsService;
import com.example.rentACar.business.dtos.listDtos.ListCreditCardDetailsDto;
import com.example.rentACar.business.requests.createRequests.CreateCreditCardDetailsRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.ErrorDataResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessDataResult;
import com.example.rentACar.core.results.SuccessResult;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.CreditCardDetailsDao;
import com.example.rentACar.entities.concretes.CreditCardDetails;

@Service
public class CreditCardDetailsManager implements CreditCardDetailsService{

	CreditCardDetailsDao creditCardDetailsDao;
	ModelMapperService modelMapperService;
	
	@Autowired
	public CreditCardDetailsManager(CreditCardDetailsDao cardDetailsDao, ModelMapperService mapperService) {
		this.creditCardDetailsDao = cardDetailsDao;
		this.modelMapperService = mapperService;
	}

	@Override
	public DataResult<List<ListCreditCardDetailsDto>> getAll() {
		
		var result = this.creditCardDetailsDao.findAll();
		
		List<ListCreditCardDetailsDto> response = result.stream()
				.map(creditCardDetails -> this.modelMapperService.forDto().map(creditCardDetails, ListCreditCardDetailsDto.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<ListCreditCardDetailsDto>>(response);
	}

	@Override
	public DataResult<ListCreditCardDetailsDto> getByCreditCardDetailsId(int creditCardDetailsId) {

		CreditCardDetails result = this.creditCardDetailsDao.getById(creditCardDetailsId);
		
		if(result == null) {
			
			return new ErrorDataResult<ListCreditCardDetailsDto>("Car.NotFound");
		}
		
		ListCreditCardDetailsDto response = this.modelMapperService.forDto().map(result, ListCreditCardDetailsDto.class);
		
		return new SuccessDataResult<ListCreditCardDetailsDto>(response);
	}
	
	@Override
	public DataResult<List<ListCreditCardDetailsDto>> getAllByCustomerId(int customerId) {
		
		var result = this.creditCardDetailsDao.findCreditCardDetailsByCustomer_CustomerId(customerId);
		
		List<ListCreditCardDetailsDto> response = result.stream()
				.map(creditCardDetails -> this.modelMapperService.forDto().map(creditCardDetails, ListCreditCardDetailsDto.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<ListCreditCardDetailsDto>>(response);
	}

	@Override
	public Result create(CreateCreditCardDetailsRequest createCreditCardDetailsRequest) throws BusinessException {
		
		CreditCardDetails creditCardDetails = this.modelMapperService.forRequest().map(createCreditCardDetailsRequest, CreditCardDetails.class);
		
		this.creditCardDetailsDao.save(creditCardDetails);
		
		return new SuccessResult("CreditCard.Added");
	}
}
