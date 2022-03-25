package com.example.rentACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.business.abstracts.CreditCardDetailsService;
import com.example.rentACar.business.dtos.listDtos.ListCreditCardDetailsDto;
import com.example.rentACar.business.requests.createRequests.CreateCreditCardDetailsRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

@RestController
@RequestMapping("/api/creditCardDetails")
public class CreditCardDetailsController {

	private CreditCardDetailsService creditCardDetailsService;

	@Autowired
	public CreditCardDetailsController(CreditCardDetailsService creditCardDetailsService) {
		this.creditCardDetailsService = creditCardDetailsService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<ListCreditCardDetailsDto>> getAll() {
		return creditCardDetailsService.getAll();
		
	}
	
	@GetMapping("/getById")
	DataResult<ListCreditCardDetailsDto> getById(@RequestParam int id) {
		return creditCardDetailsService.getById(id);
		
	}
	
	@GetMapping("/getAllByCustomerId")
	DataResult<List<ListCreditCardDetailsDto>> getAllByCustomerId(@RequestParam int customerId) {
		return creditCardDetailsService.getAllByCustomerId(customerId);
		
	}
	
	@PostMapping("/create")
	Result create(@RequestBody CreateCreditCardDetailsRequest cardDetailsRequest) throws BusinessException {
		return creditCardDetailsService.create(cardDetailsRequest);	
	}
	
}
