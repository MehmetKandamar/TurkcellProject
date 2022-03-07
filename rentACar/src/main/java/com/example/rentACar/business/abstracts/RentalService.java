package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.getByIdDtos.GetByIdRentalDto;
import com.example.rentACar.business.dtos.listDtos.ListRentalDto;
import com.example.rentACar.business.requests.createRequests.CreateRentalRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteRentalRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateRentalRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

public interface RentalService {
	DataResult<List<ListRentalDto>> getAll();
	DataResult<GetByIdRentalDto> getById(int id);
	DataResult<List<GetByIdRentalDto>> getByCarId(int id);
	
    Result add(CreateRentalRequest createRentalRequest);
    Result update(UpdateRentalRequest updateRentalRequest);
    Result delete(DeleteRentalRequest deleteRentalRequest);
}
