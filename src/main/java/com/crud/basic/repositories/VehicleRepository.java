package com.crud.basic.repositories;

import com.crud.basic.entities.Animal;
import com.crud.basic.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface VehicleRepository extends JpaRepository <Vehicle, Long>{

    Vehicle findByLicense(String license);
    Set<Vehicle> findByCategory(String category);
    Set<Vehicle> findByBodywork(String bodywork);
    Set<Vehicle> findByBrand(String brand);
    Set<Vehicle> findByModel(String model);

}
