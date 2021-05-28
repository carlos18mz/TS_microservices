package com.softper.userservice.client;

import com.softper.userservice.models.Driver;
import com.softper.userservice.resources.comunications.DriverBoundResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "driverservice")
public interface DriverClient {
    
    @RequestMapping(method = RequestMethod.POST, value = "/api/drivers")
    public ResponseEntity<Driver> generateNewDriver(@PathVariable(value = "personId")int personId);
}