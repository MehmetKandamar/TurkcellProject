package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.listDtos.ListCarDamageDto;
import com.example.rentACar.business.requests.createRequests.CreateCarDamageRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteCarDamageRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateCarDamageRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

public interface CarDamageService {

	Result delete (DeleteCarDamageRequest carDamageId);
	Result update(UpdateCarDamageRequest updateCarDamageRequest);
	Result create(CreateCarDamageRequest createCarDamageRequest);
	DataResult<List<ListCarDamageDto>> getAll();
	DataResult<List<ListCarDamageDto>> getAllByCarId(int carId);
}
