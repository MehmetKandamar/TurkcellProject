package com.example.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentACar.entities.concretes.Brand;
import com.example.rentACar.entities.concretes.Color;

@Repository
public interface ColorDao extends JpaRepository<Color, Integer>{
	Color getByColorName(String colorName);
	Color getByColorId(int colorId);
	boolean existsByColorName(String colorName);
	List<Brand> getBrandByColorName(String name);
}
