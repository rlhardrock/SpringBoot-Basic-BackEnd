package com.crud.basic.services;

import com.crud.basic.entities.Person;
import com.crud.basic.entities.Vehicle;

import java.util.List;
import java.util.Set;

public interface VehicleService {

    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(Long vehicleId);
    Vehicle getVehicleByLicense(String license);
    Set<Vehicle> getVehicleByCategory(String category);
    Set<Vehicle> getVehicleByBodywork(String bodywork);
    Set<Vehicle> getVehicleByBrand(String brand);
    Set<Vehicle> getVehicleByModel(String model);
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle patchVehicle(String license, Vehicle vehicle);
    Vehicle updateVehicle(Long vehicleId, Vehicle vehicle);
    void deleteVehicle(Long vehicleId);
    void destroyVehicle(String license);


}
