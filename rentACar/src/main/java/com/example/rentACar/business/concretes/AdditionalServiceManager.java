package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.AdditionalServiceService;
import com.example.rentACar.business.constants.Messages;
import com.example.rentACar.business.dtos.listDtos.ListAdditionalServiceDto;
import com.example.rentACar.business.requests.createRequests.CreateAdditionalServiceRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateAdditionalServiceRequest;
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
	public Result create(CreateAdditionalServiceRequest createAdditionalServiceRequest) {
		AdditionalService additionalService = this.modelMapperService.forRequest().map(createAdditionalServiceRequest, AdditionalService.class);
		this.additionalServiceDao.save(additionalService);
		return new SuccessResult(Messages.AdditionalServiceAdded);
	
	}

	@Override
	public DataResult<ListAdditionalServiceDto> findById(int id) {
		if(additionalServiceDao.existsById(id)) {
			AdditionalService additionalService = additionalServiceDao.findById(id).get();
			ListAdditionalServiceDto response = modelMapperService.forDto().map(additionalService, ListAdditionalServiceDto.class);
			return new SuccessDataResult<ListAdditionalServiceDto>(response);
		}else return new ErrorDataResult<ListAdditionalServiceDto>();
	}

	@Override
	public DataResult<List<ListAdditionalServiceDto>> getAll() {

		var result = this.additionalServiceDao.findAll();
		
		List<ListAdditionalServiceDto> response = result.stream().map(additionalService -> this.modelMapperService.forDto().map(additionalService, ListAdditionalServiceDto.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<ListAdditionalServiceDto>>(response);
				
	}

	@Override
	public Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest) {
		// TODO Auto-generated method stub
		return null;
	}


}
