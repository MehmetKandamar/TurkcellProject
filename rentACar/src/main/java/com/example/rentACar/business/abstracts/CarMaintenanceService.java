package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.getByIdDtos.GetByIdCarMaintenanceDto;
import com.example.rentACar.business.dtos.listDtos.ListCarMaintenanceDto;
import com.example.rentACar.business.requests.createRequests.CreateCarMaintenanceRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteCarMaintenanceRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateCarMaintenanceRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.entities.concretes.CarMaintenance;

public interface CarMaintenanceService {
	DataResult<List<ListCarMaintenanceDto>> getAll();
	
	Result add(CreateCarMaintenanceRequest createCarMaintenanceRequest) throws BusinessException;
	
	DataResult<GetByIdCarMaintenanceDto>  getById(int id) throws BusinessException;
	
	Result delete (DeleteCarMaintenanceRequest deleteCarMaintenanceRequest) throws BusinessException;
	
	Result update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest) throws BusinessException;
	
	DataResult<List<ListCarMaintenanceDto>> getAllPaged(int pageNo, int pageSize);

	DataResult<List<ListCarMaintenanceDto>> getAllSorted();

	DataResult<List<CarMaintenance>> findCarByCarId(int carId);
}
