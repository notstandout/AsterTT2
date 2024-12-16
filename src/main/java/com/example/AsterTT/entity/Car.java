package com.example.AsterTT.entity;

import com.example.AsterTT.dto.CarDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.Year;
import java.util.UUID;

@Entity
@Table(name = "cars", uniqueConstraints = {@UniqueConstraint(columnNames = "vin")})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String make;

    private String model;

    private int year;

    private double price;

    @Column(unique = true, length = 17)
    private String vin;

    public void setYear(int year) {
        if (year < 1886 || year > Year.now().getValue()) {
            throw new IllegalArgumentException("Year must be between 1886 and the current year.");
        }
        this.year = year;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be a positive value.");
        }
        this.price = price;
    }

    public void setVin(String vin) {
        if (vin == null || vin.length() != 17) {
            throw new IllegalArgumentException("VIN must be a non-null string of 17 characters.");
        }
        this.vin = vin;
    }


    public CarDTO toDTO() {
        return new CarDTO(this.make, this.model, this.year, this.price, this.vin);
    }

    public static Car fromDTO(CarDTO carDTO) {
        Car car = new Car();
        car.setMake(carDTO.getMake());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());
        car.setPrice(carDTO.getPrice());
        car.setVin(carDTO.getVin());
        return car;
    }
}
