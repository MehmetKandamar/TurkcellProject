package com.example.rentACar.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "corporate_customers")
@PrimaryKeyJoinColumn(name = "corporate_customer_id", referencedColumnName = "customer_id")
public class CorporateCustomer extends Customer{
	
	@Column(name = "company_name")
	private String companyName;
	 
	@Column(name = "tax_number")
	private int taxNumber;

}
