package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.CarDamageService;
import com.example.rentACar.business.constants.Messages;
import com.example.rentACar.business.dtos.listDtos.ListCarDamageDto;
import com.example.rentACar.business.requests.createRequests.CreateCarDamageRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteCarDamageRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateCarDamageRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessDataResult;
import com.example.rentACar.core.results.SuccessResult;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.CarDamageDao;
import com.example.rentACar.entities.concretes.CarDamage;

@Service
public class CarDamageManager implements CarDamageService{
	
	private CarDamageDao carDamageDao;
	private ModelMapperService modelMapperService;
	
	public CarDamageManager(CarDamageDao carDamageDao, ModelMapperService modelMapperService) {
		super();
		this.carDamageDao = carDamageDao;
		this.modelMapperService = modelMapperService;
	}


	@Override
	public Result delete(DeleteCarDamageRequest deleteCarDamageRequest) throws BusinessException{
		
		checkIfCarDamageExists(deleteCarDamageRequest.getCarDamageId());

		carDamageDao.deleteById(deleteCarDamageRequest.getCarDamageId());
		return new SuccessResult(Messages.CarDamageDeleted);
	}

	@Override
	public Result update(UpdateCarDamageRequest updateCarDamageRequest) {
		
			CarDamage carDamage = modelMapperService.forRequest().map(updateCarDamageRequest,
					CarDamage.class);
			carDamageDao.save(carDamage);
			return new SuccessResult();
	
	}

	@Override
	public Result create(CreateCarDamageRequest createCarDamageRequest) {
		CarDamage carDamage = this.modelMapperService.forRequest().map(createCarDamageRequest, CarDamage.class);
		this.carDamageDao.save(carDamage);
		return new SuccessResult(Messages.CarDamageAdded);
	}

	@Override
	public DataResult<List<ListCarDamageDto>> getAll() {
		var result = this.carDamageDao.findAll();
		List<ListCarDamageDto> response = result.stream()
				.map(car -> this.modelMapperService.forDto().map(car, ListCarDamageDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarDamageDto>>(response);
	}

	@Override
	public DataResult<List<ListCarDamageDto>> getAllByCarId(int carId) {
		var carDamages = this.carDamageDao.getAllByCar_CarId(carId).getData();
        List<ListCarDamageDto> response = carDamages.stream()
                .map(carDamage -> this.modelMapperService.forDto().map(carDamage, ListCarDamageDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListCarDamageDto>>(response);
	}
	
	private void checkIfCarDamageExists(int carDamageId) throws BusinessException {

		if (!carDamageDao.existsById(carDamageId)) {
			throw new BusinessException(Messages.DamageNotFound);
		}
	}

}
