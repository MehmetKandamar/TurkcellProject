package com.example.rentACar.business.dtos.listDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListCorporateCustomerRequestDto {

	private int corporateCustomerId;
	private String email;
	private String password;
	private String companyName;
	private int taxNumber;
}
