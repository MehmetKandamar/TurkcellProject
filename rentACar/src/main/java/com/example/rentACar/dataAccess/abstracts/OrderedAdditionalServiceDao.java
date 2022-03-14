package com.example.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentACar.entities.concretes.OrderedAdditionalService;

public interface OrderedAdditionalServiceDao extends JpaRepository<OrderedAdditionalService, Integer>{

}
