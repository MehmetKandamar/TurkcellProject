package com.example.rentACar.business.dtos.listDtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCarMaintenanceDto {
	
	private int id;
	private String description;
	private Date returnDate;
	private int carId;

}
