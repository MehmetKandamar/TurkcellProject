package com.example.rentACar.core.adapters.concretes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.rentACar.core.adapters.abstracts.BankAdapterService;
import com.example.rentACar.core.exceptions.BusinessException;
import com.example.rentACar.core.externalServices.HalkBank;
import com.example.rentACar.core.results.Result;
import com.example.rentACar.core.results.SuccessResult;

@Service
@Primary
public class HalkBankAdapterManager implements BankAdapterService{

	@Override
	public Result checkIfLimitIsEnough(String cardNo, String year, String mounth, String cVV, double amount) {
		HalkBank halkBank= new HalkBank();
		if(halkBank.isLimitExists(cardNo, year, mounth, cVV, amount))	{
			return new SuccessResult("HalkBank pos işlemi yapıldı.");
		}
		else {
			throw new BusinessException("Limit yetersiz");
		}
	}

}
