package com.example.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentACar.entities.concretes.Rental;

@Repository
public interface RentalDao extends JpaRepository<Rental, Integer>{
	Rental getRentalById(int rentalId);
	List<Rental> getRentalsByCarId(int carId);
	List<Rental> getRentalsByCustomerId(int customerId);
}
