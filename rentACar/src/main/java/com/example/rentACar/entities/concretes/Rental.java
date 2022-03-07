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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="rentals")
public class Rental {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;
	    
	    @Column(name = "rentDate")
	    private LocalDate rentDate;
	    
	    @Column(name = "returnDate")
	    private LocalDate returnDate;
	    
	    @Column(name = "customerId")
	    private int customerId;

	    @ManyToOne
	    @JoinColumn(name = "car_id")
	    private Car carId;
}
