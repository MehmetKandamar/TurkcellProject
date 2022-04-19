package com.example.rentACar.business.dtos.listDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCarDto {
	
	private int carId;
	private String carName;
	private double dailyPrice;
	private String modelYear;
	private String description;
	private String brandName;
	private String colorName;
	private int mileage;
	private String damageDescription;
}
