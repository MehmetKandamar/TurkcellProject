package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.listDtos.ListCityDto;
import com.example.rentACar.business.requests.createRequests.CreateCityRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

public interface CityService {
	DataResult<List<ListCityDto>> getAll();
	DataResult<ListCityDto> getById(int id);
	Result create(CreateCityRequest createCityRequest) throws BusinessException;

}
