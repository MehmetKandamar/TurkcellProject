package com.example.rentACar.business.dtos.listDtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCarMaintenanceDto {
	
	private int carMaintenanceId;
	private String maintenanceDescription;
	private LocalDate returnDate;
	private int carId;

}
