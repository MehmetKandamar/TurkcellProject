package com.example.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rentACar.business.dtos.ListColorDto;
import com.example.rentACar.business.requests.CreateColorRequest;

@Service
public interface ColorService {
	public List<ListColorDto> getAll();
	public void add(CreateColorRequest createColorRequest);

}
