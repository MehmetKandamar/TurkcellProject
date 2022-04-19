package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.getDtos.GetRentalDto;
import com.example.rentACar.business.dtos.listDtos.ListRentalDto;
import com.example.rentACar.business.requests.createRequests.CreateRentalRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteRentalRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateRentalRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.entities.concretes.Rental;

public interface RentalService {
	DataResult<List<ListRentalDto>> getAll();
	DataResult<GetRentalDto> getById(int id) throws BusinessException;
	DataResult<List<GetRentalDto>> getByCustomerId(int customerId);
	List<Rental> getRentalsByCarId(int carId);
	
	Result isCarRented(int carId) throws BusinessException;
    Result create(CreateRentalRequest createRentalRequest) throws BusinessException;
    Result update(UpdateRentalRequest updateRentalRequest) throws BusinessException;
    Result delete(DeleteRentalRequest deleteRentalRequest) throws BusinessException;
}
