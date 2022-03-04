package com.example.rentACar.business.requests.updateRequests;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarMaintenanceRequest {
	
	@NotNull
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min = 3, max = 150)
	private String description;
	
	@NotNull
	private int carId;
	
	@NotNull
	private LocalDate returnDate;
}
