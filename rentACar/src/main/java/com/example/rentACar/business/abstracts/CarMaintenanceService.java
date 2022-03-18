package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.listDtos.ListCarMaintenanceDto;
import com.example.rentACar.business.requests.createRequests.CreateCarMaintenanceRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteCarMaintenanceRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateCarMaintenanceRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

public interface CarMaintenanceService {
	
	Result delete (DeleteCarMaintenanceRequest deleteCarMaintenanceRequest);
	Result update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest);
	Result create(CreateCarMaintenanceRequest createCarMaintenanceRequest);
	Result isCarInMaintenance(int carId) throws BusinessException;
	DataResult<List<ListCarMaintenanceDto>> getAll();
	DataResult<List<ListCarMaintenanceDto>> getAllByCarId(int carId);
	DataResult<List<ListCarMaintenanceDto>> getAllPaged(int pageNo, int pageSize);
	DataResult<List<ListCarMaintenanceDto>> getAllSorted();
}
