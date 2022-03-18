package com.example.rentACar.business.dtos.listDtos;

import java.time.LocalDate;

import com.example.rentACar.entities.concretes.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ListInvoiceDto {


	private int invoiceId;
	private String invoiceNumber;
	private LocalDate creationDate;
	private int numberOfDaysRented;
	private int rental;
	private Customer customer;

}
