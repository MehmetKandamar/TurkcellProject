package com.example.rentACar.business.concretes;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.CarService;
import com.example.rentACar.business.dtos.getByIdDtos.GetByIdCarDto;
import com.example.rentACar.business.dtos.listDtos.ListCarDto;
import com.example.rentACar.business.requests.createRequests.CreateCarRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteCarRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateCarRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.ErrorResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessDataResult;
import com.example.rentACar.core.results.SuccessResult;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.CarDao;
import com.example.rentACar.entities.concretes.Car;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

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
	public DataResult<List<ListCarDto>> getAll() {
		var result = this.carDao.findAll();
		List<ListCarDto> response = result.stream()
				.map(car -> this.modelMapperService.forDto().map(car, ListCarDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarDto>>(response);
	}

	@Override
	public Result add(CreateCarRequest createCarRequest) throws BusinessException{
		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carDao.save(car);
		return new SuccessResult("Car.Added");
		
	}

	@Override
	public DataResult<GetByIdCarDto> getById(int carId) throws BusinessException{
		var result = this.carDao.getByCarId(carId);
		if(result != null) {
			
		GetByIdCarDto response = this.modelMapperService.forDto().map(result, GetByIdCarDto.class);
		return new SuccessDataResult<GetByIdCarDto>(response);
		
		}
		throw new BusinessException("Arabaların içerisinde böyle bir id bulunmamaktadır.");
		
		
	}

	@Override
	public Result delete(DeleteCarRequest deleteCarRequest) throws BusinessException {
		Car car = this.modelMapperService.forRequest().map(deleteCarRequest, Car.class);
		if (checkCarIdExist(car)) {
			this.carDao.deleteById(car.getCarId());
			return new SuccessResult("Car.Deleted");
		}
		return new ErrorResult("Car.NotFound");
	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) throws BusinessException {
		Car car=this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		if(checkCarIdExist(car)) {
			this.carDao.save(car);
			return new SuccessResult("Car.Updated");
		}
		return new ErrorResult("Car.NotFound");
	}
	
	private boolean checkCarIdExist(Car car) {

		return this.carDao.getByCarId(car.getCarId()) != null;

	}

	@Override
	public DataResult<List<ListCarDto>> getAllPaged(int pageNo, int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		List<Car> result=this.carDao.findAll(pageable).getContent();
		List<ListCarDto> response = result.stream()
				.map(car -> this.modelMapperService.forDto().map(car, ListCarDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarDto>>(response);
	}

	@Override
	public DataResult<List<ListCarDto>> getAllSorted() {
		Sort sort=Sort.by(Sort.Direction.ASC,"dailyPrice");
		List<Car> result=this.carDao.findAll(sort);
		List<ListCarDto> response = result.stream()
				.map(car -> this.modelMapperService.forDto().map(car, ListCarDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarDto>>(response);
	}

	@Override
	public DataResult<List<ListCarDto>> listByPriceLessThanEqual(int maxPrice) {
		List<Car> result=this.carDao.findByDailyPriceLessThanEqual(maxPrice);
		List<ListCarDto> response = result.stream()
				.map(car -> this.modelMapperService.forDto().map(car, ListCarDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarDto>>(response);
	}

}
