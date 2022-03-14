package com.example.rentACar.business.dtos.listDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListIndividualCustomerDto {

	private int individualCustomerId;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private int identityNumber;
}
