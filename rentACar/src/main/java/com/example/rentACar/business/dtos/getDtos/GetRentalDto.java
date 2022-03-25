package com.example.rentACar.business.dtos.getDtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalDto {
	
	private int rentalId;
	private LocalDate rentDate;
	private LocalDate returnDate;
	private double additionalPrice;
	private double totalPrice;
	private int customerId;
	private int carId;
	private int initialMileage;
	private int returnMileage;
	private int initialCityId;
	private int returnCityId;
}
