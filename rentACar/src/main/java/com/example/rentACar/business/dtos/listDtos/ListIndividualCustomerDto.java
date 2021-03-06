package com.example.rentACar.business.dtos.listDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListIndividualCustomerDto {

	private int customerId;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String identityNumber;
}
