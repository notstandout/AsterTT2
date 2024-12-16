package com.example.AsterTT.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    @NotBlank(message = "Make cannot be blank")
    private String make;

    @NotBlank(message = "Model cannot be blank")
    private String model;

    @Min(value = 1886, message = "Year must be no less than 1886")
    @Max(value = 2024, message = "Year cannot be greater than the current year")
    private Integer year;

    @Positive(message = "Price must be a positive number")
    private Double price;

    @Size(min = 17, max = 17, message = "VIN must be exactly 17 characters")
    private String vin;
}