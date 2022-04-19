package com.example.rentACar.business.dtos.listDtos;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCarMaintenanceDto {
	
	@NotNull
	private int car_CarId;
	
	private int carMaintenanceId;
	
	private String maintenanceDescription;
	
	@NotNull
	private LocalDate maintenanceDate;
	
	@NotNull
	private LocalDate returnDate;

}
