package com.example.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rentACar.business.dtos.ListBrandDto;
import com.example.rentACar.business.requests.CreateBrandRequest;

@Service
public interface BrandService {
	public List<ListBrandDto> getAll();
	public void add(CreateBrandRequest createBrandRequest);
	

}
