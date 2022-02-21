package com.example.rentACar.business.dtos.listDtos;

import com.example.rentACar.entities.concretes.Brand;
import com.example.rentACar.entities.concretes.Color;

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
	private Brand brand;
	private Color color;
}
