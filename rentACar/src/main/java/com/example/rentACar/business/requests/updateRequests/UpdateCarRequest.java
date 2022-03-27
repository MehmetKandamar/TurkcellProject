package com.example.rentACar.business.requests.updateRequests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
	
	@NotNull
	@Min(1)
	private int carId;
	
	@NotNull
	@Size(min=2)
	private String carName;
	
	@NotNull
	@Min(0)
	private int dailyPrice;
	
	@NotNull
	private String modelYear;
	
	@NotNull
	@Size(min=2, max=150)
	private String description;
	
	@NotNull
	@Min(1)
	private int brandId;
	
	@NotNull
	@Min(1)
	private int colorId;
	
	@NotNull
	private int mileage;
}
