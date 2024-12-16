package com.example.AsterTT.controller;

import com.example.AsterTT.dto.CarDTO;
import com.example.AsterTT.entity.Car;
import com.example.AsterTT.service.CarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Controller
@RequestMapping("/main/cars")
@Tag(name = "Car Management", description = "API для управления автомобилями")
public class MainController {

    @Autowired
    private CarService carService;

    @GetMapping("/get/{vin}")
    @Operation(summary = "Получить автомобиль по VIN", description = "Возвращает информацию об автомобиле по его VIN.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Автомобиль успешно найден"),
            @ApiResponse(responseCode = "404", description = "Автомобиль с указанным VIN не найден")
    })
    public ResponseEntity<CarDTO> getCarById(
            @Parameter(description = "VIN автомобиля", required = true) @PathVariable String vin) {
        log.info("Fetching car with VIN: {}", vin);
        Car car = carService.getCarById(vin);
        if (car == null) {
            throw new EntityNotFoundException("Car not found with VIN: " + vin);
        }
        return ResponseEntity.ok(car.toDTO());
    }

    @PostMapping("/add")
    @Operation(summary = "Добавить новый автомобиль", description = "Добавляет новый автомобиль в базу данных.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Автомобиль успешно добавлен"),
            @ApiResponse(responseCode = "400", description = "Ошибка валидации данных автомобиля")
    })
    public ResponseEntity<String> addCar(
            @Parameter(description = "Данные нового автомобиля", required = true)
            @Valid @RequestBody CarDTO carDTO) {
        log.info("Adding new car with VIN: {}", carDTO.getVin());
        carService.createCar(carDTO);
        return ResponseEntity.ok("Car added successfully");
    }

    @PutMapping("/update/{vin}")
    @Operation(summary = "Обновить данные автомобиля", description = "Обновляет информацию об автомобиле с указанным VIN.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Данные автомобиля успешно обновлены"),
            @ApiResponse(responseCode = "404", description = "Автомобиль с указанным VIN не найден"),
            @ApiResponse(responseCode = "400", description = "Ошибка валидации данных автомобиля")
    })
    public ResponseEntity<String> updateCar(
            @Parameter(description = "VIN автомобиля", required = true)
            @PathVariable String vin,
            @Parameter(description = "Новые данные автомобиля", required = true)
            @Valid @RequestBody CarDTO carDTO) {
        log.info("Updating car with VIN: {}", vin);
        carService.updateCar(vin, carDTO);
        return ResponseEntity.ok("Car updated successfully");
    }

    @DeleteMapping("/delete/{vin}")
    @Operation(summary = "Удалить автомобиль", description = "Удаляет автомобиль с указанным VIN.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Автомобиль успешно удален"),
            @ApiResponse(responseCode = "404", description = "Автомобиль с указанным VIN не найден")
    })
    public ResponseEntity<String> deleteCar(
            @Parameter(description = "VIN автомобиля", required = true)
            @PathVariable String vin) {
        log.info("Deleting car with VIN: {}", vin);
        carService.deleteCar(vin);
        return ResponseEntity.ok("Car deleted successfully");
    }

    @GetMapping("/search")
    @Operation(summary = "Поиск автомобилей", description = "Ищет автомобили по ключевому слову.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Список найденных автомобилей"),
            @ApiResponse(responseCode = "400", description = "Ошибка запроса")
    })
    public ResponseEntity<List<CarDTO>> searchCars(
            @Parameter(description = "Ключевое слово для поиска, поиск осуществляется по марке, модели и году выпуска.", required = true)
            @RequestParam String keyword) {
        log.info("Searching cars by word: {}", keyword);
        List<CarDTO> cars = carService.search(keyword).stream()
                .map(Car::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(cars);
    }

    @GetMapping("")
    @Operation(summary = "Получить список всех автомобилей", description = "Возвращает полный список автомобилей.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Список всех автомобилей")
    })
    public ResponseEntity<List<CarDTO>> getAllCars() {
        log.info("Fetching all cars");
        List<CarDTO> cars = carService.getAllCars().stream()
                .map(Car::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(cars);
    }
}