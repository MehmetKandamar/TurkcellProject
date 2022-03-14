package com.example.rentACar.business.dtos.listDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListOrderedAdditionalServiceDto {

	private int orderedAdditionalId;
	private int rentalId;
	private int additionalServiceItemId;
}
