package com.example.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentACar.entities.concretes.Payment;

public interface PaymentDao extends JpaRepository<Payment, Integer>{

	Payment getAllByRental_RentalId(int rentalId); 
}
