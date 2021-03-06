package com.example.rentACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.business.abstracts.CityService;
import com.example.rentACar.business.dtos.listDtos.ListCityDto;
import com.example.rentACar.business.requests.createRequests.CreateCityRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
	
	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/getall")
	DataResult<List<ListCityDto>> getAll() {
		return this.cityService.getAll();
		
	}
	
	@GetMapping("/getById")
	DataResult<ListCityDto> getById(@RequestParam int id){
		return this.cityService.getById(id); 
		
	}
	
	@PostMapping("/create")
	Result create(@RequestBody CreateCityRequest createCityRequest) throws BusinessException {
		return this.cityService.create(createCityRequest);		
	}

}
