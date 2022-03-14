package com.example.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentACar.entities.concretes.OrderedAdditionalService;

public interface AdditionalServiceDao extends JpaRepository<OrderedAdditionalService, Integer>{

	List<OrderedAdditionalService> findAllByRentalId(int RentalId);
}
