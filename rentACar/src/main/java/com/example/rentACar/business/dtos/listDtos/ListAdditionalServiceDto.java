package com.example.rentACar.business.dtos.listDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListAdditionalServiceDto {

	private int customerId;
	private int rentalId;
	private int additionalServiceItemId;

}
