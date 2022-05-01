package com.example.rentACar.core.adapters.concretes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.requests.createRequests.CreatePaymentRequest;
import com.example.rentACar.core.adapters.abstracts.BankAdapterService;
import com.example.rentACar.core.externalServices.HalkBank;
import com.example.rentACar.core.results.ErrorResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessResult;

@Service
@Primary
public class HalkBankAdapterManager implements BankAdapterService{

	@Override
	public Result checkIfLimitIsEnough(CreatePaymentRequest createPaymentRequest, double paymentAmount) {
		HalkBank halkBank= new HalkBank();
		boolean checkPaymentResult = halkBank.isLimitExists(createPaymentRequest.getCardNo(), 
				createPaymentRequest.getYear(),
				createPaymentRequest.getMonth(), 
				createPaymentRequest.getCardHolder(),
				createPaymentRequest.getCVV(),
				paymentAmount);
				if (checkPaymentResult) {
					return new SuccessResult();
				}
				return new ErrorResult();
	}

}
