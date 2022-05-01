package com.example.rentACar.core.adapters.abstracts;

import com.example.rentACar.business.requests.createRequests.CreatePaymentRequest;
import com.example.rentACar.core.results.Result;

public interface BankAdapterService {

	Result checkIfLimitIsEnough(CreatePaymentRequest createPaymentRequest, double paymentAmount);

}
