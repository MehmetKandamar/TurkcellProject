package com.example.rentACar.business.requests.createRequests;

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
public class CreateCarMaintenanceRequest {
	
	@NotNull
	@NotBlank
	@Size(min = 3, max = 150)
	private String description;
	
	@NotNull
	private int carId;
	
	
	private LocalDate returnDate;

}
