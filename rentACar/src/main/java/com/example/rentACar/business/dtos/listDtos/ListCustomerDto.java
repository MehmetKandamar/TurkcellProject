package com.example.rentACar.business.dtos.listDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListCustomerDto {

	private int customerId;
	private String email;
	private String password;
}
