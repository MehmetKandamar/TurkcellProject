package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.listDtos.ListIndividualCustomerDto;
import com.example.rentACar.business.requests.createRequests.CreateIndividualCustomerRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

public interface IndividualCustomerService {
	
	DataResult<List<ListIndividualCustomerDto>> getAll();
	DataResult<ListIndividualCustomerDto> getAllByCustomerId(int customerId);
	Result create(CreateIndividualCustomerRequest createIndividualCustomerRequest) throws BusinessException;

}
