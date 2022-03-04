package com.example.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rentACar.business.dtos.getByIdDtos.GetByIdCarDto;
import com.example.rentACar.business.dtos.listDtos.ListCarDto;
import com.example.rentACar.business.requests.createRequests.CreateCarRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteCarRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateCarRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

@Service
public interface CarService {
	DataResult<List<ListCarDto>> getAll();
	
	Result add(CreateCarRequest createCarRequest) throws BusinessException;
	
	DataResult<GetByIdCarDto>  getById(int id) throws BusinessException;
	
	Result delete (DeleteCarRequest deleteCarRequest) throws BusinessException;
	
	Result update(UpdateCarRequest updateCarRequest) throws BusinessException;
	
	DataResult<List<ListCarDto>> getAllPaged(int pageNo, int pageSize);

	DataResult<List<ListCarDto>> getAllSorted();

	DataResult<List<ListCarDto>> listByPriceLessThanEqual(int maxPrice);
}
