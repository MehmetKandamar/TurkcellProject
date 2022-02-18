package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.ListColorDto;
import com.example.rentACar.business.requests.CreateColorRequest;
import com.example.rentACar.core.exceptions.BusinessException;

public interface ColorService {
	public List<ListColorDto> getAll();
	public void add(CreateColorRequest createColorRequest);
	ListColorDto getById(int colorId) throws BusinessException;

}
