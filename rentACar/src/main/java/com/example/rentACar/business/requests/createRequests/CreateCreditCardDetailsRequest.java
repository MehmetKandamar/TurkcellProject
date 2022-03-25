package com.example.rentACar.business.requests.createRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditCardDetailsRequest {

private String cardNumber;
	
	
	private int cVV;
	private int year;
	private int month;
	
	private int customerId;
}
