package com.softper.userservice.client;


import com.softper.userservice.resources.comunications.ConfigBoundResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "configservice")
public interface ConfigurationClient {
    
    @RequestMapping(method = RequestMethod.POST, value = "api/configurations")
    public ResponseEntity<ConfigBoundResponse> generateConfiguration(@PathVariable(value = "userId")int userId);
    
    
}