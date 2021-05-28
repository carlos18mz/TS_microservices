package com.softper.userservice.client;

import org.springframework.http.ResponseEntity;
import com.softper.userservice.resources.comunications.ConfigBoundResponse;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationHystrixFallbackFactory implements ConfigurationClient {

    @Override
    public ResponseEntity<ConfigBoundResponse> generateConfiguration(int userId){
        ConfigBoundResponse newConfigBoundResponse = new ConfigBoundResponse("none","none",2);
        return ResponseEntity.ok(newConfigBoundResponse);
    }
}
