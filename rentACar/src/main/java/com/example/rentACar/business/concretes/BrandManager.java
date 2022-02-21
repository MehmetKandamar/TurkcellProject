package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.BrandService;
import com.example.rentACar.business.dtos.listDtos.ListBrandDto;
import com.example.rentACar.business.requests.createRequests.CreateBrandRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteBrandRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateBrandRequest;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.BrandDao;
import com.example.rentACar.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService{
	
	private BrandDao brandDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public BrandManager(BrandDao brandDao, ModelMapperService modelMapperService) {
		this.brandDao = brandDao;
		this.modelMapperService = modelMapperService;
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

	@Override
	public ListBrandDto getById(int brandId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(DeleteBrandRequest deleteBrandRequest) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

}
