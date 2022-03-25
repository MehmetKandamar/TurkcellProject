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

import com.example.rentACar.business.abstracts.CarMaintenanceService;
import com.example.rentACar.business.dtos.listDtos.ListCarMaintenanceDto;
import com.example.rentACar.business.requests.createRequests.CreateCarMaintenanceRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteCarMaintenanceRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateCarMaintenanceRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

@RestController
@RequestMapping("/api/carMaintenances")
public class CarMaintenancesController {
	
	private CarMaintenanceService carMaintenanceService;
	

	@Autowired
	public CarMaintenancesController(CarMaintenanceService carMaintenanceService) {
		this.carMaintenanceService = carMaintenanceService;
	}

	@GetMapping("/getAll")
	public DataResult<List<ListCarMaintenanceDto>> getAll() {
		return carMaintenanceService.getAll();
	}

	@GetMapping("/getAllByCarId")
	public DataResult<List<ListCarMaintenanceDto>> getAllByCarId(@RequestParam int carId) {
		return this.carMaintenanceService.getAllByCarId(carId);
	}

	@PostMapping("/create")
	public Result add(@RequestBody @Valid CreateCarMaintenanceRequest createCarMaintenanceRequest) {
		return carMaintenanceService.create(createCarMaintenanceRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteCarMaintenanceRequest deleteCarMaintenanceRequest) {
		return carMaintenanceService.delete(deleteCarMaintenanceRequest);
	}

	@PutMapping("/update")
	public Result delete(@RequestBody @Valid UpdateCarMaintenanceRequest updateCarMaintenanceRequest) {
		return carMaintenanceService.update(updateCarMaintenanceRequest);
	}

	@GetMapping("/getAllByCar/{id}")
	public DataResult<List<ListCarMaintenanceDto>> getAllByCar(@RequestParam int carId) {
		return carMaintenanceService.getAllByCarId(carId);
	}
}
