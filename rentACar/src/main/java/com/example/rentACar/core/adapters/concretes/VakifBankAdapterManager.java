package com.example.rentACar.core.adapters.concretes;

import com.example.rentACar.business.requests.createRequests.CreatePaymentRequest;
import com.example.rentACar.core.adapters.abstracts.BankAdapterService;
import com.example.rentACar.core.externalServices.VakifBank;
import com.example.rentACar.core.results.ErrorResult;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessResult;

public class VakifBankAdapterManager implements BankAdapterService{

	@Override
	public Result checkIfLimitIsEnough(CreatePaymentRequest createPaymentRequest, double paymentAmount) {

		VakifBank vakifBank = new VakifBank();
		boolean checkPaymentResult = vakifBank.isLimitExists(createPaymentRequest.getCardNo(), 
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
