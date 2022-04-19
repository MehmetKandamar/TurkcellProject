package com.example.rentACar.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.CustomerService;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.utilities.mapping.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.CustomerDao;

@Service
public class CustomerManager implements CustomerService{

	private ModelMapperService modelMapperService;
	private CustomerDao customerDao;

	@Autowired
	public CustomerManager(ModelMapperService modelMapperService, CustomerDao customerDao) {
		this.modelMapperService = modelMapperService;
		this.customerDao = customerDao;
	}
	
	@Override
	public boolean isCustomerExists(int customerId) throws BusinessException {
		if (customerDao.existsById(customerId)) {
			return true;
		}
		throw new BusinessException("Customer does not exist with id : " + customerId);
	}

}
