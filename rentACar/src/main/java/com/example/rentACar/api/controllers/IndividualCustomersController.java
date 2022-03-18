package com.example.rentACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.business.abstracts.IndividualCustomerService;
import com.example.rentACar.business.dtos.listDtos.ListIndividualCustomerDto;
import com.example.rentACar.business.requests.createRequests.CreateIndividualCustomerRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/individualCustomers")
public class IndividualCustomersController {

	private IndividualCustomerService individualCustomerService;
	
	@Autowired
	public IndividualCustomersController(IndividualCustomerService customerService) {
		this.individualCustomerService = customerService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<ListIndividualCustomerDto>> getAll() {
		return this.individualCustomerService.getAll();
		
	}
	@GetMapping("/getById")
	DataResult<ListIndividualCustomerDto> getById(@RequestParam int id) {
		return this.individualCustomerService.getById(id);
		
	}
	@PostMapping("/create")
	Result create(@RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest) {
		return this.individualCustomerService.create(createIndividualCustomerRequest);
		
	}

}
