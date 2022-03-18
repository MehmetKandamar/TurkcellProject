package com.example.rentACar.business.abstracts;

import com.example.rentACar.business.requests.createRequests.CreateOrderedAdditionalServiceRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

import java.util.List;

import com.example.rentACar.business.dtos.listDtos.ListOrderedAdditionalServiceDto;

public interface OrderedAdditionalServiceService {

	DataResult<List<ListOrderedAdditionalServiceDto>> findAllByRentalId(int rentalId);
	
	Result add(CreateOrderedAdditionalServiceRequest createOrderedAdditionalServiceRequest);

}
