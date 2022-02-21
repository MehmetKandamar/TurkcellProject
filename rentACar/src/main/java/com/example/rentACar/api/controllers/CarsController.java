package com.example.rentACar.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.business.abstracts.CarService;
import com.example.rentACar.business.dtos.getByIdDtos.GetByIdCarDto;
import com.example.rentACar.business.dtos.listDtos.ListCarDto;
import com.example.rentACar.business.requests.createRequests.CreateCarRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteCarRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateCarRequest;
import com.example.rentACar.core.exceptions.BusinessException;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
	private CarService carService;

	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}
	
	@GetMapping("/getall")
	public List<ListCarDto> getAll() {
		return this.carService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateCarRequest createCarRequest) {
		this.carService.add(createCarRequest);
	}
	
	@GetMapping(path = {"/getById", "/getById/{id}"})
	public GetByIdCarDto getById(@PathVariable(required = true, name = "id") int id) {
		return this.carService.getById(id);
	}
	
	
    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteCarRequest deleteCarRequest) throws BusinessException{
    this.carService.delete(deleteCarRequest);
    }
    
    @PutMapping("/update")
    public void update(@RequestBody UpdateCarRequest updateCarRequest) throws BusinessException{
    this.carService.update(updateCarRequest);
    }
}
