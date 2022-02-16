package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.BrandService;
import com.example.rentACar.business.dtos.ListBrandDto;
import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.BrandDao;
import com.example.rentACar.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService{
	
	private BrandDao brandDao;
	private ModelMapperService modelMapperService;

	public BrandManager(BrandDao brandDao) {
		super();
		this.brandDao = brandDao;
	}

	@Override
	public List<ListBrandDto> getAll() {
		  var result = this.brandDao.findAll();
	        List<ListBrandDto> response = result.stream()
	                .map(product->this.modelMapperService.forDto()
	                        .map(product, ListBrandDto.class)).collect(Collectors.toList());
	        return response;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		  Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
	        this.brandDao.save(brand);
	}

}
