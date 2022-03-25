package com.example.rentACar.business.dtos.listDtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListPaymentDto {

	private int paymentId;	
	private double totalPayment;	
	private LocalDate paymentDate;
	private int rentalId;
}
