package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.ColorService;
import com.example.rentACar.business.dtos.ListColorDto;
import com.example.rentACar.business.requests.CreateColorRequest;
import com.example.rentACar.core.exceptions.BusinessException;
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
	public List<ListColorDto> getAll() {
        var result = this.colorDao.findAll();
        List<ListColorDto> response = result.stream()
                .map(product->this.modelMapperService.forDto()
                        .map(product, ListColorDto.class)).collect(Collectors.toList());
        return response;

	}

	@Override
	public void add(CreateColorRequest createColorRequest) {
		   Color color = this.modelMapperService.forRequest().map(createColorRequest, Color.class);
	        this.colorDao.save(color);

	}

	@Override
	public ListColorDto getById(int colorId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
