package com.example.rentACar.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.business.abstracts.BrandService;
import com.example.rentACar.business.dtos.ListBrandDto;
import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.core.exceptions.BusinessException;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
	private BrandService brandService;

	public BrandsController(BrandService brandService) {

		this.brandService = brandService;
	}
	

	@GetMapping("/getall")
	public List<ListBrandDto> getAll() {
		return this.brandService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateBrandRequest createBrandRequest) throws BusinessException {
		this.brandService.add(createBrandRequest);
	}
	
	@GetMapping("/getbyid")
	public ListBrandDto getById(int brandId) throws BusinessException {
		return this.brandService.getById(brandId);
	}

}
