package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.listDtos.ListAdditionalServiceDto;
import com.example.rentACar.business.requests.createRequests.CreateAdditionalServiceRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

public interface AdditionalServiceService {

	Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest);
	DataResult<ListAdditionalServiceDto> findById(int additionalServiceId);
	DataResult<List<ListAdditionalServiceDto>> getAll();

}
