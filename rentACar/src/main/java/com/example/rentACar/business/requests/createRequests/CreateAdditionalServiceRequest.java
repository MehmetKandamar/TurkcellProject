package com.example.rentACar.business.requests.createRequests;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdditionalServiceRequest {

	@NotNull
	private String additionalServiceName;
	
	@NotNull
	private double additionalServicePrice;

}
