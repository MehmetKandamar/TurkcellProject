package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.ListBrandDto;
import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.core.exceptions.BusinessException;

public interface BrandService {
	public List<ListBrandDto> getAll();
	public void add(CreateBrandRequest createBrandRequest) throws BusinessException;
	ListBrandDto getById(int brandId) throws BusinessException;
	
}
