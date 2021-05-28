package com.softper.userservice.client;

import com.softper.userservice.models.Customer;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerClientHystrixFallback implements CustomerClient{

    @Override
    public ResponseEntity<Customer> generateNewCustomer(int personId) {
        Customer newCustomer = new Customer();
        newCustomer.setCargoList(null);
        newCustomer.setCredits(0.0);
        newCustomer.setId(null);
        newCustomer.setPerson(null);

        return ResponseEntity.ok(newCustomer);
    }
    
}
