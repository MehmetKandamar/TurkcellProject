package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.listDtos.ListColorDto;
import com.example.rentACar.business.requests.createRequests.CreateColorRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteColorRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateColorRequest;
import com.example.rentACar.core.exceptions.BusinessException;

public interface ColorService {
	public List<ListColorDto> getAll();
	public void add(CreateColorRequest createColorRequest);
	ListColorDto getById(int colorId) throws BusinessException;
	void delete (DeleteColorRequest deleteColorRequest) throws BusinessException;
	void update(UpdateColorRequest updateColorRequest) throws BusinessException;

}
