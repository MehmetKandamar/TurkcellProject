package com.example.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentACar.entities.concretes.Brand;

@Repository
public interface BrandDao extends JpaRepository<Brand, Integer>{
	//JpaRepository<Brand, Integer> burada diyoruz ki sen Brand tablosu için çalışacaksın ve primary key'in türü nedir bunları bildiriyoruz.
	List<Brand> getByBrandName(String brandName);
	Brand getByBrandId(int brandId);
	
}
