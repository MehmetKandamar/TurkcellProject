package com.example.rentACar.business.requests.updateRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarDamageRequest {

	private int carDamageId;
	private String carDamageDescription;
	private int carId;
}
