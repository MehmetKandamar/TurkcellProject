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
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.ErrorResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessDataResult;
import com.example.rentACar.core.results.SuccessResult;
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
	public DataResult<List<ListBrandDto>> getAll() {
		  var result = this.brandDao.findAll();
	        List<ListBrandDto> response = result.stream()
	                .map(product->this.modelMapperService.forDto()
	                        .map(product, ListBrandDto.class)).collect(Collectors.toList());
	        return new SuccessDataResult<List<ListBrandDto>>(response);
	}

	@Override
	public Result create(CreateBrandRequest createBrandRequest) throws BusinessException{
		  Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
	       if (checkIfBrandName(createBrandRequest)) {
			 this.brandDao.save(brand);
			 return new SuccessResult("Brand.added");
		}
		 return new ErrorResult("Brand.NotFound");
	        
	}

	@Override
	public DataResult<ListBrandDto> getById(int brandId) throws BusinessException {
		var result = this.brandDao.getByBrandId(brandId);
		if (result != null) {
			ListBrandDto response = this.modelMapperService.forDto().map(result, ListBrandDto.class);
			return new SuccessDataResult<ListBrandDto>(response);
		}
		throw new BusinessException("Markaların içerisinde böyle bir id bulunmamaktadır.");
	}

	private boolean checkIfBrandName(CreateBrandRequest createBrandRequest) throws BusinessException {
		Brand brand = this.brandDao.getByBrandName(createBrandRequest.getBrandName());
		if (brand == null) {
			return true;
		}
		throw new BusinessException("Aynı isimde bir marka bulunmaktadır.");
	}

	@Override
	public Result delete(DeleteBrandRequest deleteBrandRequest) throws BusinessException {

		Brand brand = this.modelMapperService.forRequest().map(deleteBrandRequest, Brand.class);
		if (checkBrandIdExist(brand)) {
			this.brandDao.deleteById(brand.getBrandId());
			return new SuccessResult("Brand.Deleted");
		}
		return new ErrorResult("Brand.NotFound");
	}

	@Override
	public Result update(UpdateBrandRequest updateBrandRequest) throws BusinessException {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		
		if (checkBrandIdExist(brand)) {
			this.brandDao.save(brand);
			return new SuccessResult("Brand.Updated");
		}
		
		return new ErrorResult("Brand.NotFound");
		
	}
	
	private boolean checkBrandIdExist(Brand brand) {

		return this.brandDao.getByBrandId(brand.getBrandId()) != null;

	}

}
