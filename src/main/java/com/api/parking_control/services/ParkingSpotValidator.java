package com.api.parking_control.services;

import com.api.parking_control.dtos.ParkingSpotDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ParkingSpotValidator {
    private final ParkingSpotService parkingSpotService;

    @Autowired
    public ParkingSpotValidator(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    public ResponseEntity<Object> validateParkingSpot(ParkingSpotDto parkingSpotDto) {
        if (parkingSpotService.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use");
        }
        if (parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use");
        }
        if (parkingSpotService.existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered for this apartment/block");
        }
        return null;
    }
}
