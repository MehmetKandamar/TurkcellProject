package com.example.rentACar.business.dtos.listDtos;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListAdditionalServiceDto {


	private int additionalServiceId;
	
	@NotNull
	private double additionalServicePrice;
	
	@NotNull
	private String additionalServiceName;

}
