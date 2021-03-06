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

import com.example.rentACar.business.abstracts.CarDamageService;
import com.example.rentACar.business.dtos.listDtos.ListCarDamageDto;
import com.example.rentACar.business.requests.createRequests.CreateCarDamageRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteCarDamageRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateCarDamageRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

@RestController
@RequestMapping("/api/carDamages")
public class CarDamagesController {

	private CarDamageService carDamageService;

	@Autowired
	public CarDamagesController(CarDamageService carDamageService) {
		this.carDamageService = carDamageService;
	}

	@PostMapping("/create")
	public Result add(@RequestBody @Valid CreateCarDamageRequest createCarDamageRequest) {
		return this.carDamageService.create(createCarDamageRequest);
	}

	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateCarDamageRequest updateCarDamageRequest) {
		return this.carDamageService.update(updateCarDamageRequest);
	}

	@GetMapping("/getAll")
	public DataResult<List<ListCarDamageDto>> getAll() {
		return this.carDamageService.getAll();
	}

	@GetMapping("/getAllByCarId/{carId}")
	public DataResult<List<ListCarDamageDto>> getAllByCarId(@RequestParam int carId) {
		return this.carDamageService.getAllByCarId(carId);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteCarDamageRequest deleteCarDamageRequest) {
		return this.carDamageService.delete(deleteCarDamageRequest);
	}
}
