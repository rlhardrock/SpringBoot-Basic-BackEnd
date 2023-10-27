package com.crud.basic.implementations;

import com.crud.basic.entities.Vehicle;
import com.crud.basic.repositories.VehicleRepository;
import com.crud.basic.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VehicleImplementation implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    /*public VehicleImplementation(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }*/
    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Long vehicleId) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        return vehicle.orElse(null);
    }

    @Override
    public Vehicle getVehicleByLicense(String license) {
        return vehicleRepository.findByLicense(license);
    }

    @Override
    public Set<Vehicle> getVehicleByCategory(String category) {
        return vehicleRepository.findByCategory(category);
    }

    @Override
    public Set<Vehicle> getVehicleByBodywork(String bodywork) {
        return vehicleRepository.findByBodywork(bodywork);
    }

    @Override
    public Set<Vehicle> getVehicleByBrand(String brand) {
        return vehicleRepository.findByBrand(brand);
    }

    @Override
    public Set<Vehicle> getVehicleByModel(String model) {
        return vehicleRepository.findByModel(model);
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle patchVehicle(String license, Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findByLicense(license);
        if (existingVehicle != null) {
            existingVehicle.setBodywork(vehicle.getBodywork());
            existingVehicle.setPlatform(vehicle.getPlatform());
            existingVehicle.setPower(vehicle.getPower());
            existingVehicle.setBrand(vehicle.getBrand());
            existingVehicle.setModel(vehicle.getModel());
            existingVehicle.setPaint(vehicle.getPaint());
            existingVehicle.setShield(vehicle.isShield());
            return vehicleRepository.save(existingVehicle);
        } else {
            return null;
        }
    }

    @Override
    public Vehicle updateVehicle(Long vehicleId, Vehicle vehicle) {
        if (vehicleRepository.existsById(vehicleId)) {
            vehicle.setVehicleId(vehicleId);
            return vehicleRepository.save(vehicle);
        }
        return null;
    }

    @Override
    public void deleteVehicle(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }

    @Override
    public void destroyVehicle(String license){
        vehicleRepository.findByLicense(license);
    }

}