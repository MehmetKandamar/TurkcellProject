package com.example.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentACar.entities.concretes.Rental;

public interface RentalDao extends JpaRepository<Rental, Integer>{
	Rental getRentalById(int id);
	List<Rental> getRentalsByCarId(int carId);
	List<Rental> getRentalsByCustomerId(int customerId);
}
