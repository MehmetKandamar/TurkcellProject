package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.listDtos.ListCreditCardDetailsDto;
import com.example.rentACar.business.requests.createRequests.CreateCreditCardDetailsRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

public interface CreditCardDetailsService {

	DataResult<List<ListCreditCardDetailsDto>> getAll();
	DataResult<ListCreditCardDetailsDto> getByCreditCardDetailsId(int creditCardDetailsId);
	
	Result create(CreateCreditCardDetailsRequest cardDetailsRequest) throws BusinessException;
	DataResult<List<ListCreditCardDetailsDto>> getAllByCustomerId(int customerId);
}
