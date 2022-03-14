package com.example.rentACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.business.abstracts.CarService;
import com.example.rentACar.business.dtos.getDtos.GetCarDto;
import com.example.rentACar.business.dtos.listDtos.ListCarDto;
import com.example.rentACar.business.requests.createRequests.CreateCarRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteCarRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateCarRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
	private CarService carService;

	@Autowired
	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ListCarDto>>  getAll() {
		return this.carService.getAll();
	}
	
	@PostMapping("/create")
	public Result add(@RequestBody CreateCarRequest createCarRequest) throws BusinessException{
		return this.carService.create(createCarRequest);
	}
	
	@GetMapping(path = {"/getById", "/getById/{id}"})
	public DataResult<GetCarDto> getById(@RequestParam("carId") int carId) throws BusinessException{
		return this.carService.getById(carId);
	}
	
	
    @DeleteMapping("/delete")
    public Result delete(@RequestBody DeleteCarRequest deleteCarRequest) throws BusinessException{
    	return this.carService.delete(deleteCarRequest);
    }
    
    @PutMapping("/update")
    public Result update(@RequestBody UpdateCarRequest updateCarRequest) throws BusinessException{
    	return this.carService.update(updateCarRequest);
    }
    
    @GetMapping("/getallPaged")
	public DataResult<List<ListCarDto>> getAllPaged(int pageNo, int pageSize){
		return this.carService.getAllPaged(pageNo, pageSize);
	}
	@GetMapping("/getallSorted")
	public DataResult<List<ListCarDto>> getAllSorted(){
		return this.carService.getAllSorted();
	}
	@GetMapping("/listbyprice")
	public DataResult<List<ListCarDto>> listByPriceLessThanEqual(int maxPrice) {
		return this.carService.listByPriceLessThanEqual(maxPrice);
	}
}
