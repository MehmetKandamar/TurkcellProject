package com.example.rentACar.business.requests.createRequests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	
	@NotNull
	@Size(min=2)
	private String carName;
	
	@NotNull
	@Min(0)
	private double dailyPrice;
	
	@NotNull
	private String modelYear;
	
	@NotNull
	@Size(min=2, max=150)
	private String description;
	
	@NotNull
	@Min(0)
	private int brandId;
	
	@NotNull
	@Min(0)
	private int colorId;
	
	@NotNull
	private int mileage;

}
