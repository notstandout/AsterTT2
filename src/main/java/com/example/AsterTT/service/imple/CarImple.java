package com.example.AsterTT.service.imple;

import com.example.AsterTT.dto.CarDTO;
import com.example.AsterTT.entity.Car;
import com.example.AsterTT.repository.CarRepo;
import com.example.AsterTT.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CarImple implements CarService {

    @Autowired
    private CarRepo carRepo;

    @Override
    public List<Car> getAllCars() {
        return carRepo.findAll();
    }

    @Override
    public Car getCarById(String vin) {
        return carRepo.findByVin(vin);
    }

    @Override
    public Car createCar(CarDTO carDTO) {
        Car car = carRepo.findByVin(carDTO.getVin());
        if (car!=null){
            throw new RuntimeException("Car with VIN: " + carDTO.getVin() + "already exists!!!");
        }
        car = Car.fromDTO(carDTO);
        return carRepo.save(car);
    }

    @Override
    public Car updateCar(String vin, CarDTO updatedCar) {
        Car existingCar = carRepo.findByVin(vin);
        if (existingCar == null) {
            throw new RuntimeException("Car not found");
        }
        Optional.ofNullable(updatedCar.getMake()).ifPresent(existingCar::setMake);
        Optional.ofNullable(updatedCar.getModel()).ifPresent(existingCar::setModel);
        Optional.ofNullable(updatedCar.getVin()).ifPresent(existingCar::setVin);

        if (updatedCar.getYear() != null && updatedCar.getYear() > 1885) {
            existingCar.setYear(updatedCar.getYear());
        }
        if (updatedCar.getPrice() != null && updatedCar.getPrice() > 0) {
            existingCar.setPrice(updatedCar.getPrice());
        }
        return carRepo.save(existingCar);
    }

    @Transactional
    @Override
    public void deleteCar(String vin) {
        if (!carRepo.existsByVin(vin)) {
            throw new RuntimeException("Car not found");
        }
        carRepo.deleteByVin(vin);
    }

    @Override
    public List<Car> search(String keyword) {
        return carRepo.search(keyword);
    }
}
