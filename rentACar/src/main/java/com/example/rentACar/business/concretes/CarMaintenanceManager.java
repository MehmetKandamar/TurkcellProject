package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.CarMaintenanceService;
import com.example.rentACar.business.dtos.getDtos.GetCarMaintenanceDto;
import com.example.rentACar.business.dtos.listDtos.ListCarMaintenanceDto;
import com.example.rentACar.business.requests.createRequests.CreateCarMaintenanceRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteCarMaintenanceRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateCarMaintenanceRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.ErrorResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessDataResult;
import com.example.rentACar.core.results.SuccessResult;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.CarMaintenanceDao;
import com.example.rentACar.entities.concretes.CarMaintenance;

@Service
public class CarMaintenanceManager implements CarMaintenanceService{
	
	private CarMaintenanceDao carMaintenanceDao;
	private ModelMapperService modelMapperService;
	
	public CarMaintenanceManager(CarMaintenanceDao carMaintenanceDao, ModelMapperService modelMapperService) {
		super();
		this.carMaintenanceDao = carMaintenanceDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<ListCarMaintenanceDto>> getAll() {
		var result = this.carMaintenanceDao.findAll();
		List<ListCarMaintenanceDto> response = result.stream()
				.map(car -> this.modelMapperService.forDto().map(car, ListCarMaintenanceDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarMaintenanceDto>>(response);
	}

	@Override
	public Result create(CreateCarMaintenanceRequest createCarMaintenanceRequest) {
		CarMaintenance carMaintenance = this.modelMapperService.forRequest().map(createCarMaintenanceRequest, CarMaintenance.class);
		this.carMaintenanceDao.save(carMaintenance);
		return new SuccessResult("CarMaintenance.Added");
	}

	@Override
	public DataResult<GetCarMaintenanceDto> getByCarId(int carId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(DeleteCarMaintenanceRequest deleteCarMaintenanceRequest) {
		CarMaintenance carMaintenance = this.modelMapperService.forRequest().map(deleteCarMaintenanceRequest, CarMaintenance.class);
		this.carMaintenanceDao.delete(carMaintenance);
		return new SuccessResult("CarMaintenance.deleted");
	}

	@Override
	public Result update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest) {
		if (carMaintenanceDao.existsById(updateCarMaintenanceRequest.getCarId())) {
			CarMaintenance carMaintenance = modelMapperService.forRequest().map(updateCarMaintenanceRequest,
					CarMaintenance.class);
			carMaintenanceDao.save(carMaintenance);
			return new SuccessResult();
		}
		return new ErrorResult("The maintenance was not found!");
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
	public DataResult<List<CarMaintenance>> getCarByCarId(int carId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
