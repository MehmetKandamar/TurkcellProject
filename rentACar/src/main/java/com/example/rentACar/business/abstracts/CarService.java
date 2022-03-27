package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.getDtos.GetCarDto;
import com.example.rentACar.business.dtos.listDtos.ListCarDto;
import com.example.rentACar.business.requests.createRequests.CreateCarRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteCarRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateCarRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

public interface CarService {

	Result create(CreateCarRequest createCarRequest) throws BusinessException;
	Result delete (DeleteCarRequest deleteCarRequest) throws BusinessException;
	Result update(UpdateCarRequest updateCarRequest) throws BusinessException;
	
	DataResult<ListCarDto>  getById(int id) throws BusinessException;
	DataResult<List<ListCarDto>> getAll();
	DataResult<List<ListCarDto>> getAllPaged(int pageNo, int pageSize);
	DataResult<List<ListCarDto>> getAllSorted();
	DataResult<List<ListCarDto>> listByPriceLessThanEqual(int maxPrice);
}
