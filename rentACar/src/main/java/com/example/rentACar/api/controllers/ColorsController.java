package com.example.rentACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.business.abstracts.ColorService;
import com.example.rentACar.business.dtos.listDtos.ListColorDto;
import com.example.rentACar.business.requests.createRequests.CreateColorRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteColorRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateColorRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

@RestController
@RequestMapping("/api/colors")
public class ColorsController {

	private ColorService colorService;
	
	@Autowired
	public ColorsController(ColorService colorService) {
		this.colorService = colorService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ListColorDto>>  getAll(){
		return this.colorService.getAll();
	}
	
	@PostMapping("/create")
	public Result add(@RequestBody CreateColorRequest createColorRequest) throws BusinessException {
		return this.colorService.create(createColorRequest);
	}
	
	@GetMapping("/getbyid")
	public DataResult<ListColorDto>  getById(int colorId) throws BusinessException {
		return this.colorService.getById(colorId);
	}
	
	  @DeleteMapping("/delete")
	    public Result delete(@RequestBody DeleteColorRequest deleteColorRequest) throws BusinessException{
		  return this.colorService.delete(deleteColorRequest);
	    }
	    
	    @PutMapping("/update")
	    public Result update(@RequestBody UpdateColorRequest updateColorRequest) throws BusinessException{
	    	return this.colorService.update(updateColorRequest);
	    }

}
