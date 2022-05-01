package com.example.rentACar.business.requests.createRequests;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentRequest {

	@NotNull
	private LocalDate paymentDate;

	private String cardNo;
	private String year;
	private String month;
	private String cVV;
	private String cardHolder;
	private double amount;
}
