package com.example.rentACar.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cars")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private int carId;
	
	@Column(name ="car_name")
	private String carName;
	
	@Column(name="daily_price")
	private double dailyPrice;
	
	@Column(name="model_year")
	private String modelYear;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="color_id")
	private Color color;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
	private List<CarMaintenance>  carMaintenances;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
	private List<Rental> rentals;
	
	@Column(name = "mileage")
	private Integer mileage;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
	List<CarDamage> carDamages;

}
