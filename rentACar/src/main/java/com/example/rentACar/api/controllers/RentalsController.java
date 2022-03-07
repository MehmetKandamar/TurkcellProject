package com.example.rentACar.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.business.abstracts.RentalService;
import com.example.rentACar.business.dtos.listDtos.ListRentalDto;
import com.example.rentACar.business.requests.createRequests.CreateRentalRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteRentalRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateRentalRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

@RestController
@RequestMapping("/api/rentals")
public class RentalsController {
	private final RentalService rentalService;

	@Autowired
	public RentalsController(RentalService rentalService) {
		this.rentalService = rentalService;
	}

	@GetMapping("/getAll")
	public DataResult<List<ListRentalDto>> getAll() {
		return rentalService.getAll();
	}

	@GetMapping("/get/{id}")
	public DataResult<RentalDto> get(@RequestParam int id) {
		return rentalService.getById(id);
	}

	@PostMapping("/save")
	public Result add(@RequestBody @Valid CreateRentalRequest createRentalRequest) {
		return rentalService.add(createRentalRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteRentalRequest deleteRentalRequest) {
		return rentalService.delete(deleteRentalRequest);
	}

	@PutMapping("/update")
	public Result delete(@RequestBody @Valid UpdateRentalRequest updateRentalRequest) {
		return rentalService.update(updateRentalRequest);
	}

}
