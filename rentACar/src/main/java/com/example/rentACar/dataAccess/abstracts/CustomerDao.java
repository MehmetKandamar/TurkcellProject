package com.example.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentACar.entities.concretes.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
