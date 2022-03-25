package com.example.rentACar.core.adapters.abstracts;

import com.example.rentACar.core.results.Result;

public interface BankAdapterService {

	Result checkIfLimitIsEnough(String cardNo, String year, String mounth, String cVV, double amount);

}
