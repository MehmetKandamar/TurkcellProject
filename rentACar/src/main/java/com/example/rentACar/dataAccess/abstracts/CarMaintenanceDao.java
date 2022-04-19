package com.example.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentACar.entities.concretes.CarMaintenance;
import com.example.rentACar.entities.concretes.Rental;

@Repository
public interface CarMaintenanceDao extends JpaRepository<CarMaintenance, Integer>{
	
	List<CarMaintenance> getAllByCar_CarId(int carId);
	List<CarMaintenance> findMaintenancesByCar_CarId(int carId);
	CarMaintenance findByCarMaintenanceIdAndReturnDateIsNull(int carMaintenanceId);
}
