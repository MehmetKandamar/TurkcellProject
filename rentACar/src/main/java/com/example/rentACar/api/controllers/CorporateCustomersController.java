package com.example.rentACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.business.abstracts.CorporateCustomerService;
import com.example.rentACar.business.dtos.listDtos.ListCorporateCustomerDto;
import com.example.rentACar.business.requests.createRequests.CreateCorporateCustomerRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/corporateCustomers")
public class CorporateCustomersController {

private CorporateCustomerService corporateCustomerService;
	
	@Autowired
	public CorporateCustomersController(CorporateCustomerService corporateCustomerService) {
		this.corporateCustomerService = corporateCustomerService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<ListCorporateCustomerDto>> getAll() {
		return this.corporateCustomerService.getAll();
		
	}
	@GetMapping("/getById")
	DataResult<ListCorporateCustomerDto> getById(@RequestParam int id) {
		return this.corporateCustomerService.getById(id);
		
	}
	@PostMapping("/create")
	Result create(@RequestBody CreateCorporateCustomerRequest createCorporateCustomerRequest) throws BusinessException {
		return this.corporateCustomerService.create(createCorporateCustomerRequest);
		
	}

}
