package com.example.rentACar.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.AdditionalServiceService;
import com.example.rentACar.business.dtos.listDtos.ListAdditionalServiceDto;
import com.example.rentACar.business.requests.createRequests.CreateAdditionalServiceRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.ErrorDataResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessDataResult;
import com.example.rentACar.core.results.SuccessResult;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.AdditionalServiceDao;
import com.example.rentACar.entities.concretes.AdditionalService;

@Service
public class AdditionalServiceManager implements AdditionalServiceService {

	private ModelMapperService modelMapperService;
	private AdditionalServiceDao additionalServiceDao;

	@Autowired
	public AdditionalServiceManager(ModelMapperService modelMapperService,
			AdditionalServiceDao additionalServiceDao) {

		this.modelMapperService = modelMapperService;
		this.additionalServiceDao = additionalServiceDao;
	}

	@Override
	public Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest) {
		AdditionalService additionalService = this.modelMapperService.forRequest().map(createAdditionalServiceRequest, AdditionalService.class);
		this.additionalServiceDao.save(additionalService);
		return new SuccessResult("AdditionalService.Added");
	
	}

	@Override
	public DataResult<ListAdditionalServiceDto> findById(int id) {
		if(additionalServiceDao.existsById(id)) {
			AdditionalService additionalService = additionalServiceDao.findById(id).get();
			ListAdditionalServiceDto response = modelMapperService.forDto().map(additionalService, ListAdditionalServiceDto.class);
			return new SuccessDataResult<ListAdditionalServiceDto>(response);
		}else return new ErrorDataResult<ListAdditionalServiceDto>();
	}


}
