package com.example.rentACar.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="rentals")
public class Rental {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private int rentalId;
    
    @Column(name = "rent_date")
    private LocalDate rentDate;
    
    @Column(name = "return_date")
    private LocalDate returnDate;
    
    @ManyToOne
    @JoinColumn(name = "initial_city_id")
    private City initialCity;
    
    @ManyToOne
    @JoinColumn(name = "return_city_id")
    private City returnCity;
    
    @Column(name = "initial_mileage")
    private Integer initialMileage;
    
    @Column(name = "return_mileage")
    private Integer returnMileage;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer; 

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    
    @OneToMany( mappedBy = "rental")
	private List<OrderedAdditionalService> orderedAdditionalService;
    
    
    @OneToMany(mappedBy = "customer")
    private List<Payment> payments;

}
