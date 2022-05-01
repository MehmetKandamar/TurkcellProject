package com.example.rentACar.api.models;

import com.example.rentACar.business.requests.createRequests.CreatePaymentRequest;
import com.example.rentACar.business.requests.createRequests.CreateRentalRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentModel {
	private CreateRentalRequest createRentalRequest;
	private CreatePaymentRequest createPaymentRequest;
	private String invoiceNumber;

}
