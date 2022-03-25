package com.example.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.entities.concretes.CarDamage;

@Repository
public interface CarDamageDao extends JpaRepository<CarDamage, Integer>{

	//@Query(value = "select cd from CarDamage cd where cd.car.carId = ?1")//jpql --> araştır.
	DataResult<List<CarDamage>> getAllByCar_CarId(int carId);
}
