package com.example.rentACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.business.abstracts.IndividualCustomerService;
import com.example.rentACar.business.dtos.listDtos.ListIndividualCustomerDto;
import com.example.rentACar.business.requests.createRequests.CreateIndividualCustomerRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;


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
	DataResult<ListIndividualCustomerDto> getByCustomerId(@RequestParam int customerId) {
		return this.individualCustomerService.getAllByCustomerId(customerId);
		
	}
	@PostMapping("/create")
	Result create(@RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest) {
		
		return this.individualCustomerService.create(createIndividualCustomerRequest);
		
	}

}
