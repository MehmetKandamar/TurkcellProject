package com.example.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentACar.entities.concretes.CreditCardDetails;

@Repository
public interface CreditCardDetailsDao extends JpaRepository<CreditCardDetails, Integer>{

	List<CreditCardDetails> findAllByCustomer_CustomerId(int customerId);
}
