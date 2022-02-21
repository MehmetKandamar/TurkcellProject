package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.CarService;
import com.example.rentACar.business.dtos.getByIdDtos.GetByIdCarDto;
import com.example.rentACar.business.dtos.listDtos.ListCarDto;
import com.example.rentACar.business.requests.createRequests.CreateCarRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteCarRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateCarRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.CarDao;
import com.example.rentACar.entities.concretes.Car;

@Service
public class CarManager implements CarService{
	private CarDao carDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CarManager(CarDao carDao, ModelMapperService modelMapperService) {
		super();
		this.carDao = carDao;
		this.modelMapperService = modelMapperService;
	}
	
	@Override
	public List<ListCarDto> getAll() {
		var result = this.carDao.findAll();
		List<ListCarDto> response = result.stream()
				.map(car -> this.modelMapperService.forDto().map(car, ListCarDto.class))
				.collect(Collectors.toList());
		return response;
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {
		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carDao.save(car);
		
	}

	@Override
	public GetByIdCarDto getById(int id) {
		var result = this.carDao.getById(id);
		GetByIdCarDto response = this.modelMapperService.forDto().map(result, GetByIdCarDto.class);
		return response;
	}

	@Override
	public void delete(DeleteCarRequest deleteCarRequest) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UpdateCarRequest updateCarRequest) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

}
