package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.CityService;
import com.example.rentACar.business.constants.Messages;
import com.example.rentACar.business.dtos.listDtos.ListCityDto;
import com.example.rentACar.business.requests.createRequests.CreateCityRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.ErrorDataResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessDataResult;
import com.example.rentACar.core.results.SuccessResult;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.CityDao;
import com.example.rentACar.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	private ModelMapperService modelMapperService;
	
	
	public CityManager(CityDao cityDao, ModelMapperService modelMapperService) {
		this.cityDao = cityDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<ListCityDto>> getAll() {
		
		var result = this.cityDao.findAll();
		
		List<ListCityDto> response = result.stream()
				.map(city -> this.modelMapperService.forDto().map(city, ListCityDto.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<ListCityDto>>(response);
	}

	@Override
	public DataResult<ListCityDto> getById(int id) {
		
		City result = this.cityDao.getById(id);
		
		if(result == null) {
			return new ErrorDataResult<ListCityDto>(Messages.CityNotFound);
		}
		ListCityDto response = this.modelMapperService.forDto().map(result, ListCityDto.class);		
		
		return new SuccessDataResult<ListCityDto>(response);
	}

	@Override
	public Result create(CreateCityRequest createCityRequest) throws BusinessException {
		
	City city = this.modelMapperService.forRequest().map(createCityRequest, City.class);
		
		this.cityDao.save(city);
		
		return new SuccessResult(Messages.CityAdded);
	}

}
