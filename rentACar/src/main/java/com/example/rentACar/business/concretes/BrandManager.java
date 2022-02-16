package com.example.rentACar.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.BrandService;
import com.example.rentACar.business.dtos.ListBrandDto;
import com.example.rentACar.business.requests.CreateBrandRequest;

@Service
public class BrandManager implements BrandService{

	@Override
	public List<ListBrandDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		// TODO Auto-generated method stub
		
	}

}
