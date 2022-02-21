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

@RestController
@RequestMapping("/api/colors")
public class ColorsController {

	private ColorService colorService;
	
	@Autowired
	public ColorsController(ColorService colorService) {
		this.colorService = colorService;
	}
	
	@GetMapping("/getall")
	public List<ListColorDto> getAll(){
		return this.colorService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateColorRequest createColorRequest) throws BusinessException {
		this.colorService.add(createColorRequest);
	}
	
	@GetMapping("/getbyid")
	public ListColorDto getById(int colorId) throws BusinessException {
		return this.colorService.getById(colorId);
	}
	
	  @DeleteMapping("/delete")
	    public void delete(@RequestBody DeleteColorRequest deleteColorRequest) throws BusinessException{
	    this.colorService.delete(deleteColorRequest);
	    }
	    
	    @PutMapping("/update")
	    public void update(@RequestBody UpdateColorRequest updateColorRequest) throws BusinessException{
	    this.colorService.update(updateColorRequest);
	    }

}
