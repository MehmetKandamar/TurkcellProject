package com.example.rentACar.entities.concretes;

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
@Table(name = "credit_card_details")
public class CreditCardDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int creditCardDetailsId;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "cvv")
	private int cVV;

	@Column(name = "year")
	private int year;

	@Column(name = "month")
	private int month;

	@ManyToOne
	@JoinColumn(name = "customer_id") 
	private Customer customer;
}
