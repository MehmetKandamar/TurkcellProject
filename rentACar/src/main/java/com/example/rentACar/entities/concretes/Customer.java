package com.example.rentACar.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
@PrimaryKeyJoinColumn(name = "customer_id", referencedColumnName = "user_id")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends User{
	
	@Column(name="customer_id", insertable = false, updatable = false)
	private int customerId;
	
	@Column(name="registration_date")
	private LocalDate registrationDate;
	 
	@OneToMany(mappedBy = "customer")
    private List<Rental> rentals;
	
	@OneToMany(mappedBy = "customer")
    private List<Payment> payments;
	
	@OneToMany(mappedBy = "customer")
	private List<Invoice> invoices;
	
	@OneToMany(mappedBy = "customer")
    private List<CreditCardDetails> creditCardDetails;
}
