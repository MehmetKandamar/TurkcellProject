package com.example.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentACar.entities.concretes.Car;

@Repository
public interface CarDao extends JpaRepository<Car, Integer>{
	Car getByCarId(int carId);
	List<Car> findByDailyPriceLessThanEqual(double price);
}
