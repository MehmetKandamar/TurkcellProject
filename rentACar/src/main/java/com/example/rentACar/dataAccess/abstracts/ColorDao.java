package com.example.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentACar.entities.concretes.Color;

@Repository
public interface ColorDao extends JpaRepository<Color, Integer>{

}
