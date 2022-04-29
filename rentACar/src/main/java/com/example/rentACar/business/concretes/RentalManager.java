package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.CarMaintenanceService;
import com.example.rentACar.business.abstracts.CarService;
import com.example.rentACar.business.abstracts.CustomerService;
import com.example.rentACar.business.abstracts.RentalService;
import com.example.rentACar.business.constants.Messages;
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
import com.example.rentACar.entities.concretes.CarMaintenance;
import com.example.rentACar.entities.concretes.Rental;

@Service
public class RentalManager implements RentalService{

	private final RentalDao rentalDao;
	private final ModelMapperService modelMapperService;
	private final CarMaintenanceService carMaintenanceService;
	private final CarService carService;
	private final CustomerService customerService;

	@Autowired
	public RentalManager(RentalDao rentalDao, ModelMapperService modelMapperService,
			CarMaintenanceService carMaintenanceService, CarService carService, CustomerService customerService) {
		this.rentalDao = rentalDao;
		this.modelMapperService = modelMapperService;
		this.carMaintenanceService = carMaintenanceService;
		this.carService = carService;
		this.customerService = customerService;
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
		return new ErrorDataResult<GetRentalDto>(Messages.CarRentalNotFound);
	}

	@Override
	public DataResult<List<GetRentalDto>> getByCustomerId(int customerId) {
		
		var result = this.rentalDao.findAllByCustomer_CustomerId(customerId);
        
        List<GetRentalDto> response = result.stream()
        		.map(rental -> this.modelMapperService.forDto().map(rental, GetRentalDto.class))
        		.collect(Collectors.toList());
        return new SuccessDataResult<List<GetRentalDto>>(response);
	}

	@Override
	public Result create(CreateRentalRequest createRentalRequest) throws BusinessException{
		
		isCarAvaibleToRent(createRentalRequest);
		
		Rental rental = this.modelMapperService.forRequest().map(createRentalRequest, Rental.class);
		this.rentalDao.save(rental);
		return new SuccessResult(Messages.TheRentalInformationOfTheCarWithId +createRentalRequest.getCarId()+ Messages .HasBeenUpdatedFromTheDatabase);
	}

	@Override
	public Result update(UpdateRentalRequest updateRentalRequest) {
		
		Rental rental = this.modelMapperService.forRequest().map(updateRentalRequest, Rental.class);

		if (!checkIsUnderMaintenance(rental)) {
			return new ErrorResult(Messages.CarRentalNotUpdated + Messages.CarIsUnderMaintenanceAtRequestedTimes);
		}
		this.rentalDao.save(rental);
		return new SuccessResult(Messages.TheRentalInformationOfTheCarWithId +updateRentalRequest.getCarId()+Messages.HasBeenUpdatedFromTheDatabase);
	}

	@Override
	public Result delete(DeleteRentalRequest deleteRentalRequest) {
		Rental rental = this.modelMapperService.forRequest().map(deleteRentalRequest, Rental.class);
		this.rentalDao.delete(rental);
		return new SuccessResult(Messages.TheRentalInformationOfTheCarWithId+deleteRentalRequest.getId()+Messages.HasBeenDeletedFromTheDatabase);
	}


	@Override
	public Result isCarRented(int carId) throws BusinessException {
		if (this.rentalDao.findByCar_CarIdAndReturnDateIsNull(carId) != null) {
			throw new BusinessException(Messages.TheCarIsRentedBySomeoneElse);
		} else
			return new SuccessResult();
	}
	
	private boolean checkIsUnderMaintenance(Rental rental) {
		return false;
	}


	@Override
	public List<Rental> getRentalsByCarId(int carId) {
		
		List<Rental> rentals = rentalDao.findRentalsByCar_CarId(carId);
		if (rentals.isEmpty()) {
			return null;
		}
		return rentals;
	}
	
	private void isCarAvaibleToRent(CreateRentalRequest createRentalRequest) throws BusinessException{
		
		List<CarMaintenance> maintenances = this.carMaintenanceService.getMaintenancesByCarId(createRentalRequest.getCarId());
		
		if(maintenances != null) {
			if (maintenances.isEmpty()) {
				
			}
			for (CarMaintenance maintenance : maintenances) {
				if (maintenance.getMaintenanceDate() == null){
					throw new BusinessException("Araç bakımda ve dönüş tarihi belli değil");
				}
			}
			
			for (CarMaintenance maintenance : maintenances) {
				
				if (createRentalRequest.getReturnDate().isBefore(maintenance.getReturnDate()) || createRentalRequest.getReturnDate().isAfter(maintenance.getMaintenanceDate())) {
					throw new BusinessException("Araç kirada ve bakıma gönderilemez.");
				}
			}
		}
		
	}
	
	

}
