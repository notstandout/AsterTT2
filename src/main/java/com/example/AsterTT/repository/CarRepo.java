package com.example.AsterTT.repository;

import com.example.AsterTT.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepo extends JpaRepository<Car, UUID> {

    @Query("SELECT c FROM Car c WHERE " +
            "LOWER(c.make) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
            "LOWER(c.model) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
            "CAST(c.year AS string) LIKE CONCAT('%', :query, '%')")
    List<Car> search(@Param("query") String query);


    Car findByVin(String vin);

    boolean existsByVin(String vin);

    void deleteByVin(String vin);
}

