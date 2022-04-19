package com.example.rentACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.business.abstracts.AdditionalServiceService;
import com.example.rentACar.business.dtos.listDtos.ListAdditionalServiceDto;
import com.example.rentACar.business.requests.createRequests.CreateAdditionalServiceRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;


@RestController
@RequestMapping("/api/additionalServices")
public class AdditionalServicesController {

	private AdditionalServiceService additionalServiceService;

	@Autowired
	public AdditionalServicesController(AdditionalServiceService additionalServiceService) {
		this.additionalServiceService = additionalServiceService;
	}
	
	@PostMapping("/create")
	public Result create(@RequestBody CreateAdditionalServiceRequest createAdditionalServiceRequest) {
		return this.additionalServiceService.create(createAdditionalServiceRequest);
	}
	
	@GetMapping("/findById")
	public DataResult<ListAdditionalServiceDto> findById(@RequestParam int id){
		return this.additionalServiceService.findById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ListAdditionalServiceDto>> getAll(){
		
		return additionalServiceService.getAll();	}

}
