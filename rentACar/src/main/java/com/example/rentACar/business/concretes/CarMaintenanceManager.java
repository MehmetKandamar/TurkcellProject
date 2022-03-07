package com.example.rentACar.business.concretes;

import java.util.List;

import com.example.rentACar.business.abstracts.CarMaintenanceService;
import com.example.rentACar.business.dtos.getByIdDtos.GetByIdCarMaintenanceDto;
import com.example.rentACar.business.dtos.listDtos.ListCarMaintenanceDto;
import com.example.rentACar.business.requests.createRequests.CreateCarMaintenanceRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteCarMaintenanceRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateCarMaintenanceRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.entities.concretes.CarMaintenance;

public class CarMaintenanceManager implements CarMaintenanceService{

	@Override
	public DataResult<List<ListCarMaintenanceDto>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(CreateCarMaintenanceRequest createCarMaintenanceRequest) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<GetByIdCarMaintenanceDto> getById(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(DeleteCarMaintenanceRequest deleteCarMaintenanceRequest) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<ListCarMaintenanceDto>> getAllPaged(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<ListCarMaintenanceDto>> getAllSorted() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<CarMaintenance>> findCarByCarId(int carId) {
		// TODO Auto-generated method stub
		return null;
	}

}
