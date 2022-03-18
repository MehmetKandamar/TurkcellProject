package com.example.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentACar.entities.concretes.Invoice;

public interface InvoiceDao extends JpaRepository<Invoice, Integer>{

}
