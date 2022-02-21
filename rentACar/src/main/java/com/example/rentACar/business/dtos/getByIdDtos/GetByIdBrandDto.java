package com.example.rentACar.business.dtos.getByIdDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdBrandDto {
	private int brandId;
	private String brandName;
}
