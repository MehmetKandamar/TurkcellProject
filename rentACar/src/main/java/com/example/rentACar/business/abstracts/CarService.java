package com.example.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rentACar.business.dtos.getByIdDtos.GetByIdCarDto;
import com.example.rentACar.business.dtos.listDtos.ListCarDto;
import com.example.rentACar.business.requests.createRequests.CreateCarRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteCarRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateCarRequest;
import com.example.rentACar.core.exceptions.BusinessException;

@Service
public interface CarService {
	List<ListCarDto> getAll();
	void add(CreateCarRequest createCarRequest);
	GetByIdCarDto getById(int id);
	void delete (DeleteCarRequest deleteCarRequest) throws BusinessException;
	void update(UpdateCarRequest updateCarRequest) throws BusinessException;
}
