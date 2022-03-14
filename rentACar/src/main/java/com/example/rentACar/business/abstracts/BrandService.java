package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.listDtos.ListBrandDto;
import com.example.rentACar.business.requests.createRequests.CreateBrandRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteBrandRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateBrandRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

public interface BrandService {
	DataResult<List<ListBrandDto>> getAll();
	DataResult<ListBrandDto> getById(int brandId) throws BusinessException;
	Result create(CreateBrandRequest createBrandRequest) throws BusinessException;
	Result delete (DeleteBrandRequest deleteBrandRequest) throws BusinessException;
	Result update(UpdateBrandRequest updateBrandRequest) throws BusinessException;
	
}
