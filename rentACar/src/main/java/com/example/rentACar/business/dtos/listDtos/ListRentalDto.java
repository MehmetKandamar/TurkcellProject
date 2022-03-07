package com.example.rentACar.business.dtos.listDtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListRentalDto {
	private int id;
	private int carId;
	private int customerId;
	private LocalDate rentDate;
	private LocalDate returnDate;
}
