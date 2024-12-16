package com.example.AsterTT.service;

import com.example.AsterTT.dto.CarDTO;
import com.example.AsterTT.entity.Car;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarService {
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    List<Car> getAllCars();

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    Car getCarById(String vin);

    @PreAuthorize("hasRole('ADMIN')")
    Car createCar(CarDTO carDTO);

    @PreAuthorize("hasRole('ADMIN')")
    Car updateCar(String vin, CarDTO updatedCar);

    @PreAuthorize("hasRole('ADMIN')")
    void deleteCar(String vin);

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<Car> search(String keyword);
}
