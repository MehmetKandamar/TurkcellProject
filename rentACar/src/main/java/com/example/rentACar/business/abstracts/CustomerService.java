package com.example.rentACar.business.abstracts;

import com.example.rentACar.core.exceptions.BusinessException;

public interface CustomerService {

	public boolean isCustomerExists(int customerId) throws BusinessException;
}
