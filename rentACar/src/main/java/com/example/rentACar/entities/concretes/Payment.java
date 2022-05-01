package com.example.rentACar.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private int paymentId;
	
	@Column(name = "payment_amount")
	private double paymentAmount;
	
	@Column(name = "payment_date")
	private LocalDate paymentDate;
	
	@Column(name = "card_number")
	private String cardNumber;
	
	@Column(name = "card_holder")
	private String cardHolder;

	@Column(name = "cvv")
	private int cVV;

	@Column(name = "year")
	private int year;

	@Column(name = "month")
	private int month;
	
	@ManyToOne
	@JoinColumn(name = "rental_id")	
	private Rental rental;
	
	@ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
