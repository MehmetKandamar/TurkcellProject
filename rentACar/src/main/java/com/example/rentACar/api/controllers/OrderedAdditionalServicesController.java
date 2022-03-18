package com.example.rentACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.business.abstracts.OrderedAdditionalServiceService;
import com.example.rentACar.business.dtos.listDtos.ListOrderedAdditionalServiceDto;
import com.example.rentACar.business.requests.createRequests.CreateOrderedAdditionalServiceRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/orderedAdditionalServices")
public class OrderedAdditionalServicesController {

	private OrderedAdditionalServiceService orderedAdditionalServiceService;

	@Autowired
	public OrderedAdditionalServicesController(OrderedAdditionalServiceService orderedAdditionalServiceService) {
		this.orderedAdditionalServiceService = orderedAdditionalServiceService;
	}
	
	@PostMapping("/create")
	public Result add(@RequestBody CreateOrderedAdditionalServiceRequest createOrderedAdditionalServiceRequest) {
		return this.orderedAdditionalServiceService.add(createOrderedAdditionalServiceRequest);
	}
	
	@GetMapping("/findById")
	public DataResult<List<ListOrderedAdditionalServiceDto>> findAllByRentalId(@RequestParam int rentalId){
		return this.orderedAdditionalServiceService.findAllByRentalId(rentalId);
	}

}
