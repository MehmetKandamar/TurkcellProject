package com.example.rentACar.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="additional_services")
public class AdditionalService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="additional_service_id") 
	private int additionalServiceId;
	
	
	@Column(name="additional_service_name") 
	private String additionalServiceName;
	
	@Column(name="additional_service_price") 
	private double additionalServicePrice;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "additionalService")
	private List<OrderedAdditionalService> additionalServices;

}
