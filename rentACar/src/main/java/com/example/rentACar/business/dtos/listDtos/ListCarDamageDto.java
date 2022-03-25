package com.example.rentACar.business.dtos.listDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCarDamageDto {

	private int carId;//carCarId
	private int carDamageId;
	private String damageDescription;
	
}
