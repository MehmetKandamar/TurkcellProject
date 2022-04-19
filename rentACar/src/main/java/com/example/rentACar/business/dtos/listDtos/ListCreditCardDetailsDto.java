package com.example.rentACar.business.dtos.listDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCreditCardDetailsDto {

	private int id;
	private String cardNumber;
	private int customerId;
	private int cVV;
	private int year;
	private int month;
}
