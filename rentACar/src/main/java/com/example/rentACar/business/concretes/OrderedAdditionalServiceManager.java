package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.OrderedAdditionalServiceService;
import com.example.rentACar.business.abstracts.RentalService;
import com.example.rentACar.business.dtos.listDtos.ListOrderedAdditionalServiceDto;
import com.example.rentACar.business.requests.createRequests.CreateOrderedAdditionalServiceRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessDataResult;
import com.example.rentACar.core.results.SuccessResult;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.OrderedAdditionalServiceDao;
import com.example.rentACar.entities.concretes.OrderedAdditionalService;

@Service
public class OrderedAdditionalServiceManager implements OrderedAdditionalServiceService{
	
	private OrderedAdditionalServiceDao orderedAdditionalServiceDao;
	private ModelMapperService modelMapperService;
		
	@Autowired
	public OrderedAdditionalServiceManager(OrderedAdditionalServiceDao orderedAdditionalServiceDao, ModelMapperService modelMapperService,
			RentalService rentalService) {
		super();
		this.orderedAdditionalServiceDao = orderedAdditionalServiceDao;
		this.modelMapperService = modelMapperService;
	}
	
	@Override
	public Result add(CreateOrderedAdditionalServiceRequest createOrderedAdditionalServiceRequest) {
		OrderedAdditionalService orderedAdditionalService = this.modelMapperService.forRequest().map(createOrderedAdditionalServiceRequest, OrderedAdditionalService.class);
		
		orderedAdditionalService.setOrderedAdditionalServiceId(0);
		this.orderedAdditionalServiceDao.save(orderedAdditionalService);
		return new SuccessResult("OrderedAdditionalService.Added");
	}

	@Override
	public DataResult<List<ListOrderedAdditionalServiceDto>> findAllByRentalId(int rentalId) {
		List<OrderedAdditionalService> orderedAdditionalServiceList = this.orderedAdditionalServiceDao.findAllByRental_RentalId(rentalId);
		List<ListOrderedAdditionalServiceDto> response = orderedAdditionalServiceList.stream().map(
				orderedAdditionalService -> modelMapperService.forDto().map(orderedAdditionalService, ListOrderedAdditionalServiceDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ListOrderedAdditionalServiceDto>>(response);
	}

}
