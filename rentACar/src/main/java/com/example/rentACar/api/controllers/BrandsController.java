package com.example.rentACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.business.abstracts.BrandService;
import com.example.rentACar.business.dtos.listDtos.ListBrandDto;
import com.example.rentACar.business.requests.createRequests.CreateBrandRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteBrandRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateBrandRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
	private BrandService brandService;
	
	@Autowired
	public BrandsController(BrandService brandService) {

		this.brandService = brandService;
	}
	

	@GetMapping("/getall")
	public DataResult<List<ListBrandDto>>  getAll() {
		return this.brandService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateBrandRequest createBrandRequest) throws BusinessException {
		return this.brandService.add(createBrandRequest);
	}
	
	@GetMapping("/getbyid")
	public DataResult<ListBrandDto> getById(int brandId) throws BusinessException {
		return this.brandService.getById(brandId);
	}
	
	@DeleteMapping("/delete")
    public Result delete(@RequestBody DeleteBrandRequest deleteBrandRequest) throws BusinessException{
    return this.brandService.delete(deleteBrandRequest);
    }
    
    @PutMapping("/update")
    public Result update(@RequestBody UpdateBrandRequest updateBrandRequest) throws BusinessException{
    return this.brandService.update(updateBrandRequest);
    }

}
