package com.example.rentACar.business.requests.deleteRequests;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeletePaymentRequest {

	@NotNull
	private int paymentId;
}
