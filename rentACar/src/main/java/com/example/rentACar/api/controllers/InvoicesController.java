package com.example.rentACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.business.abstracts.InvoiceService;
import com.example.rentACar.business.dtos.listDtos.ListInvoiceDto;
import com.example.rentACar.business.requests.createRequests.CreateInvoiceRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteInvoiceRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateInvoiceRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

@RestController
@RequestMapping("/api/invoices")
public class InvoicesController {

	private InvoiceService invoiceService;

	@Autowired
	public InvoicesController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<ListInvoiceDto>> getAll(){
	return this.invoiceService.getAll();
	}
	
	@PostMapping("/create")
	Result create(@RequestBody CreateInvoiceRequest createInvoiceRequest) {
		return this.invoiceService.create(createInvoiceRequest);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody DeleteInvoiceRequest deleteInvoiceRequest) {
		return this.invoiceService.delete(deleteInvoiceRequest);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody UpdateInvoiceRequest updateInvoiceRequest) {
		return this.invoiceService.update(updateInvoiceRequest);
	}
}
