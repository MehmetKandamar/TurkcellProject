package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.listDtos.ListColorDto;
import com.example.rentACar.business.requests.createRequests.CreateColorRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteColorRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateColorRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

public interface ColorService {
	DataResult<List<ListColorDto>>  getAll();
	Result create(CreateColorRequest createColorRequest) throws BusinessException;
	DataResult<ListColorDto> getById(int colorId) throws BusinessException;
	Result delete (DeleteColorRequest deleteColorRequest) throws BusinessException;
	Result update(UpdateColorRequest updateColorRequest) throws BusinessException;

}
