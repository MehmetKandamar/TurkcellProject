package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.api.models.CreatePaymentModel;
import com.example.rentACar.business.dtos.listDtos.ListPaymentDto;
import com.example.rentACar.business.requests.deleteRequests.DeletePaymentRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

public interface PaymentService {

	Result add(CreatePaymentModel createPaymentModel);
	Result delete(DeletePaymentRequest deletePaymentRequest);

	DataResult<List<ListPaymentDto>> getAll();
	DataResult<List<ListPaymentDto>> getAllPaged(int pageNo, int pageSize);
	DataResult<ListPaymentDto> getByRentalId(int rentalId);
	
	boolean checkPaymentRentalId(int rentalId);
}
