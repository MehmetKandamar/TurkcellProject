package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rentACar.business.abstracts.RentalService;
import com.example.rentACar.business.dtos.getByIdDtos.GetByIdRentalDto;
import com.example.rentACar.business.dtos.listDtos.ListRentalDto;
import com.example.rentACar.business.requests.createRequests.CreateRentalRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteRentalRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateRentalRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.ErrorDataResult;
import com.example.rentACar.core.results.ErrorResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessDataResult;
import com.example.rentACar.core.results.SuccessResult;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.CarDao;
import com.example.rentACar.dataAccess.abstracts.CarMaintenanceDao;
import com.example.rentACar.dataAccess.abstracts.RentalDao;
import com.example.rentACar.entities.concretes.CarMaintenance;
import com.example.rentACar.entities.concretes.Rental;

public class RentalManager implements RentalService{

	private RentalDao rentalDao;
	private CarMaintenanceDao carMaintenanceDao;
	private CarDao carDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public RentalManager(CarMaintenanceDao carMaintenanceDao,CarDao carDao ,RentalDao rentalDao, ModelMapperService modelMapperService) {
		this.rentalDao=rentalDao;
		this.carMaintenanceDao = carMaintenanceDao;
		this.carDao = carDao;
		this.modelMapperService=modelMapperService;
	}
	
	@Override
	public DataResult<List<ListRentalDto>> getAll() {
		
		var result = this.rentalDao.findAll();
		
		List<ListRentalDto> response = result.stream()
				.map(carRental -> modelMapperService.forDto().map(carRental, ListRentalDto.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<ListRentalDto>>(response);
	}

	@Override
	public DataResult<GetByIdRentalDto> getById(int id) {
		
		Rental rental = rentalDao.getById(id);
		if (rental != null) {
			GetByIdRentalDto response = modelMapperService.forDto().map(rental, GetByIdRentalDto.class);
			return new SuccessDataResult<GetByIdRentalDto>(response);
		}
		return new ErrorDataResult<GetByIdRentalDto>("CarRental.NotFound");
	}

	@Override
	public DataResult<List<GetByIdRentalDto>> getByCarId(int carId) {
		
		var result = this.rentalDao.getRentalsByCarId(carId);
        
        List<GetByIdRentalDto> response = result.stream()
        		.map(rental -> this.modelMapperService.forDto().map(rental, GetByIdRentalDto.class))
        		.collect(Collectors.toList());
        return new SuccessDataResult<List<GetByIdRentalDto>>(response);
	}

	@Override
	public Result add(CreateRentalRequest createRentalRequest) {
		
		Rental rental = this.modelMapperService.forRequest().map(createRentalRequest, Rental.class);
		
		if (!checkIsUnderMaintenance(rental)) {
			return new ErrorResult("CarRental.NotAdded , Car is under maintenance!");
		}
		this.rentalDao.save(rental);
		return new SuccessResult("The rental information of the vehicle with id "+createRentalRequest.getCarId()+" has been updated from the database.");
	}

	@Override
	public Result update(UpdateRentalRequest updateRentalRequest) {
		
		Rental rental = this.modelMapperService.forRequest().map(updateRentalRequest, Rental.class);

		if (!checkIsUnderMaintenance(rental)) {
			return new ErrorResult("CarRental.NotUpdated , Car is under maintenance at requested times");
		}
		this.rentalDao.save(rental);
		return new SuccessResult("The rental information of the vehicle with id "+updateRentalRequest.getCarId()+" has been updated from the database.");
	}

	@Override
	public Result delete(DeleteRentalRequest deleteRentalRequest) {
		Rental rental = this.modelMapperService.forRequest().map(deleteRentalRequest, Rental.class);
		this.rentalDao.delete(rental);
		return new SuccessResult("The rental information of the vehicle with id "+deleteRentalRequest.getId()+" has been deleted from the database.");
	}
	
	private boolean checkIsUnderMaintenance(Rental rental) {
		List<CarMaintenance> result = this.carMaintenanceDao.getByCarId(rental.getCar().getId());
		if (result != null) {
			for (CarMaintenance carMaintenance : result) {
				if (rental.getRentDate().isBefore(carMaintenance.getReturnDate()) || rental.getReturnDate().isBefore(carMaintenance.getReturnDate())) {
					return false;
				}
			}
		}
		return true;
	}

}
