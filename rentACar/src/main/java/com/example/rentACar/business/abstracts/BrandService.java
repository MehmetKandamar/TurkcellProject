package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.listDtos.ListBrandDto;
import com.example.rentACar.business.requests.createRequests.CreateBrandRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteBrandRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateBrandRequest;
import com.example.rentACar.core.exceptions.BusinessException;

public interface BrandService {
	public List<ListBrandDto> getAll();
	public void add(CreateBrandRequest createBrandRequest) throws BusinessException;
	ListBrandDto getById(int brandId) throws BusinessException;
	void delete (DeleteBrandRequest deleteBrandRequest) throws BusinessException;
	void update(UpdateBrandRequest updateBrandRequest) throws BusinessException;
	
}
