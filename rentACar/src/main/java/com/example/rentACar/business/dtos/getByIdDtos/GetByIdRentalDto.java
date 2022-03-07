package com.example.rentACar.business.dtos.getByIdDtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdRentalDto {
	private int id;
	private int carId;
	private int customerId;
	private LocalDate rentDate;
	private LocalDate returnDate;
}
