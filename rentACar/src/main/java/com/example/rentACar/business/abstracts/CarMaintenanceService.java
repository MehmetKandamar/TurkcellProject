package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.getDtos.GetCarMaintenanceDto;
import com.example.rentACar.business.dtos.listDtos.ListCarMaintenanceDto;
import com.example.rentACar.business.requests.createRequests.CreateCarMaintenanceRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteCarMaintenanceRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateCarMaintenanceRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.entities.concretes.CarMaintenance;

public interface CarMaintenanceService {
	DataResult<List<ListCarMaintenanceDto>> getAll();
	
	Result create(CreateCarMaintenanceRequest createCarMaintenanceRequest);
	
	DataResult<GetCarMaintenanceDto>  getByCarId(int carId);
	
	Result delete (DeleteCarMaintenanceRequest deleteCarMaintenanceRequest);
	
	Result update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest);
	
	DataResult<List<ListCarMaintenanceDto>> getAllPaged(int pageNo, int pageSize);

	DataResult<List<ListCarMaintenanceDto>> getAllSorted();

	DataResult<List<CarMaintenance>> getCarByCarId(int carId);
}
