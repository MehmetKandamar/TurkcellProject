package com.example.rentACar.business.requests.createRequests;
import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {
	
	@Min(value = 1, message = "Car id should be positive integer")
	private int carId;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate rentDate;
	
	private int initialCityId;
    private int initialMileage;
    private int returnMileage;
    private int customerId;

}
