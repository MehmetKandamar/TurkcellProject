package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.AdditionalServiceService;
import com.example.rentACar.business.abstracts.CarMaintenanceService;
import com.example.rentACar.business.abstracts.CarService;
import com.example.rentACar.business.abstracts.OrderedAdditionalServiceService;
import com.example.rentACar.business.abstracts.RentalService;
import com.example.rentACar.business.dtos.getDtos.GetRentalDto;
import com.example.rentACar.business.dtos.listDtos.ListRentalDto;
import com.example.rentACar.business.requests.createRequests.CreateRentalRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteRentalRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateRentalRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.ErrorDataResult;
import com.example.rentACar.core.results.ErrorResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessDataResult;
import com.example.rentACar.core.results.SuccessResult;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.RentalDao;
import com.example.rentACar.entities.concretes.Rental;

@Service
public class RentalManager implements RentalService{

	private RentalDao rentalDao;
	private ModelMapperService modelMapperService;
	private CarMaintenanceService carMaintenanceService;
	private CarService carService;
	private AdditionalServiceService additionalServiceService;
	private OrderedAdditionalServiceService orderedAdditionalServiceService;

	
	@Autowired
	public RentalManager(RentalDao rentalDao, ModelMapperService modelMapperService, 
			@Lazy CarMaintenanceService carMaintenanceService, CarService carService, 
			@Lazy OrderedAdditionalServiceService orderedAdditionalServiceService, 
			AdditionalServiceService additionalServiceService) {
		
		this.rentalDao = rentalDao;
		this.modelMapperService = modelMapperService;
		this.carMaintenanceService = carMaintenanceService;
		this.carService = carService;
		this.additionalServiceService = additionalServiceService;
		this.orderedAdditionalServiceService = orderedAdditionalServiceService;
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
	public DataResult<GetRentalDto> getById(int id) {
		
		Rental rental = rentalDao.getById(id);
		if (rental != null) {
			GetRentalDto response = modelMapperService.forDto().map(rental, GetRentalDto.class);
			return new SuccessDataResult<GetRentalDto>(response);
		}
		return new ErrorDataResult<GetRentalDto>("CarRental.NotFound");
	}

	@Override
	public DataResult<List<GetRentalDto>> getByCustomerId(int customerId) {
		
		var result = this.rentalDao.findAllByCustomerId(customerId);
        
        List<GetRentalDto> response = result.stream()
        		.map(rental -> this.modelMapperService.forDto().map(rental, GetRentalDto.class))
        		.collect(Collectors.toList());
        return new SuccessDataResult<List<GetRentalDto>>(response);
	}

	@Override
	public Result create(CreateRentalRequest createRentalRequest) {
		
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
		return false;
	}


	@Override
	public Result isCarRented(int carId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
