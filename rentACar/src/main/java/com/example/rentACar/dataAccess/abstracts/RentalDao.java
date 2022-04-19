package com.example.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentACar.entities.concretes.Rental;

@Repository
public interface RentalDao extends JpaRepository<Rental, Integer>{
	List<Rental> findAllByCustomer_CustomerId(int customerId);
	Rental findByCar_CarIdAndReturnDateIsNull(int carId);
	List<Rental> findRentalsByCar_CarId(int carId);

}
