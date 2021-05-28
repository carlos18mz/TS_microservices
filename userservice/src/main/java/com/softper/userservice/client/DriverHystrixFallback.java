package com.softper.userservice.client;

import com.softper.userservice.models.Driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DriverHystrixFallback implements DriverClient{


    @Override
    public ResponseEntity<Driver> generateNewDriver(int personId) {
       Driver newDriver = new Driver();
       newDriver.setId(null);
       newDriver.setLicense(null);
       newDriver.setPerson(null);

       return ResponseEntity.ok(newDriver);
    }
    
}
