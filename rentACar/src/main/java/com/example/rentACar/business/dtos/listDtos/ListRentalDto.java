package com.example.rentACar.business.dtos.listDtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListRentalDto {

    private int rentalId;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private double additionalPrice;    
    private int customerId;
    private int carId;
    private int initialMileage;
    private int returnMileage;

}
