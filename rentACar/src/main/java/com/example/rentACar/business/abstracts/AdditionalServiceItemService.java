package com.example.rentACar.business.abstracts;

import com.example.rentACar.business.dtos.listDtos.ListAdditionalServiceItemDto;
import com.example.rentACar.business.requests.createRequests.CreateOrderedAdditionalServiceItemRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

public interface AdditionalServiceItemService {

	Result add(CreateOrderedAdditionalServiceItemRequest createAdditionalServiceItemRequest);
	DataResult<ListAdditionalServiceItemDto> findById(int id);

}
