package com.example.rentACar.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.business.abstracts.PaymentService;
import com.example.rentACar.business.dtos.listDtos.ListPaymentDto;
import com.example.rentACar.business.requests.createRequests.CreatePaymentRequest;
import com.example.rentACar.business.requests.deleteRequests.DeletePaymentRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

@RestController
@RequestMapping("/api/payment")
public class PaymentsController {

private PaymentService paymentService ;
	
	@Autowired	
	public PaymentsController(PaymentService paymentService) {		
		this.paymentService = paymentService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreatePaymentRequest createPaymentRequest)  {
		return this.paymentService.add(createPaymentRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeletePaymentRequest deletePaymentRequest)  {
		return this.paymentService.delete(deletePaymentRequest);
	}


	@GetMapping("/getAll")
	public DataResult<List<ListPaymentDto>> getAll() {
		return this.paymentService.getAll();
	}

	@PostMapping("/getAllPaged")
	public DataResult<List<ListPaymentDto>> getAllPaged(int pageNo, int pageSize) {
		return this.paymentService.getAllPaged(pageNo, pageSize);
	}

	@GetMapping("/getPaymentByRentalId")
	public DataResult<ListPaymentDto> getByRentalId(int rentalId)  {
		return this.paymentService.getByRentalId(rentalId);
	}
}
