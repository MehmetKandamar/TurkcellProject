package com.example.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentACar.entities.concretes.CarMaintenance;

@Repository
public interface CarMaintenanceDao extends JpaRepository<CarMaintenance, Integer>{
	List<CarMaintenance> getAllByCarMaintenanceId(int carMaintenanceId);
	
	CarMaintenance findByCarMaintenanceIdAndReturnDateIsNull(int carMaintenanceId);
}
