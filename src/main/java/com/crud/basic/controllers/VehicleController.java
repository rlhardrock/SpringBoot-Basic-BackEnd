package com.crud.basic.controllers;

import com.crud.basic.entities.Vehicle;
import com.crud.basic.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        try {
            Vehicle vehicleBuilt = vehicleService.createVehicle(vehicle);
            return new ResponseEntity<>(vehicleBuilt, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long vehicleId) {
        Vehicle vehicleLocated = vehicleService.getVehicleById(vehicleId);
        if (vehicleLocated != null) {
            return new ResponseEntity<>(vehicleLocated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{license}")
    public ResponseEntity<Vehicle> getVehicleByLicense(@PathVariable String license) {
        Vehicle vehicleSelected = vehicleService.getVehicleByLicense(license);
        if (vehicleSelected != null) {
            return new ResponseEntity<>(vehicleSelected, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehiclesReady = vehicleService.getAllVehicles();
        return new ResponseEntity<>(vehiclesReady, HttpStatus.OK);
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{license}")
    public ResponseEntity<Void> destroyVehicle(@PathVariable String license) {
        vehicleService.destroyVehicle(license);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{license}") //Actualización Parcial por Licencia
    public ResponseEntity<Vehicle> patchVehicle(@PathVariable String license, @RequestBody Vehicle vehicle) {
        Vehicle vehicleImproved = vehicleService.patchVehicle(license, vehicle);
        if (vehicleImproved != null) {
            return new ResponseEntity<>(vehicleImproved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{vehicleId}")  //Actualizar Completa por ID
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long vehicleId, @RequestBody Vehicle vehicle) {
        Vehicle vehicleFixed = vehicleService.updateVehicle(vehicleId, vehicle);
        if (vehicleFixed != null) {
            return new ResponseEntity<>(vehicleFixed, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
