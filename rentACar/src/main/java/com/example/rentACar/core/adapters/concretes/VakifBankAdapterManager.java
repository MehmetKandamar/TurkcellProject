package com.example.rentACar.core.adapters.concretes;

import com.example.rentACar.core.adapters.abstracts.BankAdapterService;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.externalServices.VakifBank;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessResult;

public class VakifBankAdapterManager implements BankAdapterService{

	@Override
	public Result checkIfLimitIsEnough(String cardNo, String year, String mounth, String cVV, double amount) {

		VakifBank vakifBank = new VakifBank();
		if(vakifBank.isLimitExists(cardNo, year, mounth, cVV, amount))	{ // createpaymenttan yap
			return new SuccessResult("Vakıfbank pos işlemi yapıldı.");
		}
		else {
			throw new BusinessException("Limit yetersiz");
		}
	}

}
