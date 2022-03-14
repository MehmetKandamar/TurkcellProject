package com.example.rentACar.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="additional_service_items")
public class AdditionalServiceItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="additional_service_item_id") 
	private int additionalServiceItemId; 
	
	@Column(name="additional_service_item_name") 
	private String additionalServiceItemName;
	
	@Column(name="additional_service_item_price") 
	private double additionalServiceItemPrice;
	
	@OneToMany(mappedBy = "additionalServiceItem")
	private List<OrderedAdditionalService> additionalServices;

}
