package com.example.rentACar.business.dtos.getDtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarMaintenanceDto {

	private String description;
	private Date returnDate;
	private int carId;
}
