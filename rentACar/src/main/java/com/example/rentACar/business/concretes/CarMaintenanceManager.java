package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.CarMaintenanceService;
import com.example.rentACar.business.abstracts.RentalService;
import com.example.rentACar.business.constants.Messages;
import com.example.rentACar.business.dtos.listDtos.ListCarMaintenanceDto;
import com.example.rentACar.business.requests.createRequests.CreateCarMaintenanceRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteCarMaintenanceRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateCarMaintenanceRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.ErrorResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessDataResult;
import com.example.rentACar.core.results.SuccessResult;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.CarMaintenanceDao;
import com.example.rentACar.entities.concretes.CarMaintenance;
import com.example.rentACar.entities.concretes.Rental;

@Service
public class CarMaintenanceManager implements CarMaintenanceService{
	 
	// Dependencies
	private CarMaintenanceDao carMaintenanceDao;
	private ModelMapperService modelMapperService;
	private RentalService rentalService;
	
	//Dependency Injection
	public CarMaintenanceManager(CarMaintenanceDao carMaintenanceDao, ModelMapperService modelMapperService, @Lazy RentalService rentalService) {
		super();
		this.carMaintenanceDao = carMaintenanceDao;
		this.modelMapperService = modelMapperService;
		this.rentalService = rentalService;
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
		isCarAvaibleToMaintenance(createCarMaintenanceRequest);
		CarMaintenance carMaintenance = this.modelMapperService.forRequest().map(createCarMaintenanceRequest, CarMaintenance.class);
		this.carMaintenanceDao.save(carMaintenance);
		return new SuccessResult(Messages.CarMaintenanceAdded);
	}

	@Override
	public Result delete(DeleteCarMaintenanceRequest deleteCarMaintenanceRequest) {
		CarMaintenance carMaintenance = this.modelMapperService.forRequest().map(deleteCarMaintenanceRequest, CarMaintenance.class);
		this.carMaintenanceDao.delete(carMaintenance);
		return new SuccessResult(Messages.CarMaintenancedeleted);
	}

	@Override
	public Result update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest) {
		if (carMaintenanceDao.existsById(updateCarMaintenanceRequest.getCarId())) {
			CarMaintenance carMaintenance = modelMapperService.forRequest().map(updateCarMaintenanceRequest,
					CarMaintenance.class);
			carMaintenanceDao.save(carMaintenance);
			return new SuccessResult();
		}
		return new ErrorResult(Messages.Themaintenancewasnotfound);
	}

	@Override
	public DataResult<List<ListCarMaintenanceDto>> getAllPaged(int pageNo, int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		List<CarMaintenance> result=this.carMaintenanceDao.findAll(pageable).getContent();
		List<ListCarMaintenanceDto> response = result.stream()
				.map(carMaintenance -> this.modelMapperService.forDto().map(carMaintenance, ListCarMaintenanceDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarMaintenanceDto>>(response);
	}

	@Override
	public DataResult<List<ListCarMaintenanceDto>> getAllSorted() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<ListCarMaintenanceDto>> getAllByCarId(int carId) {
		
        List<CarMaintenance> carMaintenanceList = this.carMaintenanceDao.getAllByCar_CarId(carId);
        List<ListCarMaintenanceDto> response = carMaintenanceList.stream()
                .map(carMaintenance -> modelMapperService.forDto().map(carMaintenance, ListCarMaintenanceDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListCarMaintenanceDto>>(response);


	}

	@Override
	public Result isCarInMaintenance(int carId) throws BusinessException {
		if(this.carMaintenanceDao.findByCarMaintenanceIdAndReturnDateIsNull(carId) != null)
			throw new BusinessException(Messages.RentalCantBeAddedCarIsUnderMaintenanceAtRequestedTimes);
		
		else
			return new SuccessResult();

	}
	
	private void isCarAvaibleToMaintenance(CreateCarMaintenanceRequest createCarMaintenanceRequest) throws BusinessException{
		
		List<Rental> rentals = this.rentalService.getRentalsByCarId(createCarMaintenanceRequest.getCarId());
		
		if(rentals != null) {
			if (rentals.isEmpty()) {
				
			}
			for (Rental rental : rentals) {
				if (rental.getRentDate() == null){
					throw new BusinessException(Messages.CarIsUnderMaintenanceAndReturnDateUnknown);
				}
			}
			
			for (Rental rental : rentals) {
				
				if (createCarMaintenanceRequest.getReturnDate().isBefore(rental.getReturnDate()) || createCarMaintenanceRequest.getReturnDate().isAfter(rental.getRentDate())) {
					throw new BusinessException(Messages.CarIsUnderRentAndCantBeMaintenanced);
				}
			}
		}
		
	}

	@Override
	public List<CarMaintenance> getMaintenancesByCarId(int carId) {
		List<CarMaintenance> maintenances = carMaintenanceDao.findMaintenancesByCar_CarId(carId);
		if (maintenances.isEmpty()) {
			return null;
		}
		return maintenances;
	}
	
	
}
