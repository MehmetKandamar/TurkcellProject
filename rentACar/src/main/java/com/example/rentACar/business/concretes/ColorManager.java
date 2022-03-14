package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.ColorService;
import com.example.rentACar.business.dtos.listDtos.ListColorDto;
import com.example.rentACar.business.requests.createRequests.CreateColorRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteColorRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateColorRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.ErrorResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessDataResult;
import com.example.rentACar.core.results.SuccessResult;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.ColorDao;
import com.example.rentACar.entities.concretes.Color;

@Service
public class ColorManager implements ColorService{
	
	private ColorDao colorDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public ColorManager(ColorDao colorDao, ModelMapperService modelMapperService) {
		this.colorDao = colorDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<ListColorDto>> getAll() {
        var result = this.colorDao.findAll();
        List<ListColorDto> response = result.stream()
                .map(product->this.modelMapperService.forDto()
                        .map(product, ListColorDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<ListColorDto>>(response);

	}

	@Override
	public Result create(CreateColorRequest createColorRequest) throws BusinessException{
		   Color color = this.modelMapperService.forRequest().map(createColorRequest, Color.class);
		   if(colorDao.existsByColorName(createColorRequest.getColorName())) {
			   return new ErrorResult("Color.NotFound");
		   }
		  colorDao.save(color);
		  return new SuccessResult();
	}

	@Override
	public DataResult<ListColorDto> getById(int colorId) throws BusinessException {
		var result = this.colorDao.getByColorId(colorId);
		if (result != null) {
			ListColorDto response = this.modelMapperService.forDto().map(result, ListColorDto.class);
			return new SuccessDataResult<ListColorDto>(response);
		}
		throw new BusinessException("Renklerin içerisinde böyle bir id bulunmamaktadır.");
	}

	@Override
	public Result delete(DeleteColorRequest deleteColorRequest) throws BusinessException {
		Color color = this.modelMapperService.forRequest().map(deleteColorRequest, Color.class);
		if (checkColorIdExist(color)) {
			this.colorDao.deleteById(color.getColorId());
			return new SuccessResult("Color.Deleted");
		}
		return new ErrorResult("Color.NotFound");
	}

	@Override
	public Result update(UpdateColorRequest updateColorRequest) throws BusinessException {
		Color color = this.modelMapperService.forRequest().map(updateColorRequest, Color.class);
		if (checkColorIdExist(color)) {
			this.colorDao.save(color);
			return new SuccessResult("Color.Updated");
		}
		return new ErrorResult("Color.NotFound");
	}
	
	private boolean checkColorIdExist(Color color) {

		return this.colorDao.getByColorId(color.getColorId()) != null;

	}

}
