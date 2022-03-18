package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.listDtos.ListCorporateCustomerDto;
import com.example.rentACar.business.requests.createRequests.CreateCorporateCustomerRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

public interface CorporateCustomerService {
	
	DataResult<List<ListCorporateCustomerDto>> getAll();
	DataResult<ListCorporateCustomerDto> getById(int id);
	Result create(CreateCorporateCustomerRequest createCorporateCustomerRequest) throws BusinessException;

}
