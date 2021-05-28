package com.softper.userservice.controllers;

import com.softper.userservice.resources.comunications.UserBoundResponse;
import com.softper.userservice.resources.inputs.RefreshInput;
import com.softper.userservice.resources.inputs.SignIn;
import com.softper.userservice.resources.inputs.SignUp;
import com.softper.userservice.servicesImp.AuthService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;
import java.util.Date;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/userservice/authentication")
public class AuthenticationController {

    @Autowired
    private AuthService authService;


    @PostMapping(value = "/sign-in-fixed")
    public ResponseEntity<UserBoundResponse> SignInFixed(@Valid @RequestBody SignIn signIn) throws Exception {
        if(signIn == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        HttpHeaders responseHeaders = new HttpHeaders();
        UserBoundResponse result = authService.loginFixed(signIn.getEmail(), signIn.getPassword());

        //responseHeaders.add("Auth-Token", result.getResource().getToken());

        //if(!result.success)
            //return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(result, responseHeaders,HttpStatus.OK);
    }

    @PostMapping(value = "/sign-in")
    public ResponseEntity<UserBoundResponse> SignIn(@Valid @RequestBody SignIn signIn) throws Exception {
        if(signIn == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        HttpHeaders responseHeaders = new HttpHeaders();
        UserBoundResponse result = authService.login(signIn.getEmail(), signIn.getPassword());

        responseHeaders.add("Auth-Token", result.getAuthenticatedOutput().getToken());

        //if(!result.success)
            //return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(result, responseHeaders,HttpStatus.OK);
    }

    @PostMapping(value = "/sign-up")
    public ResponseEntity<UserBoundResponse> SignUp(@Valid @RequestBody SignUp signUp) throws Exception {

        UserBoundResponse result = authService.registerComplete(signUp);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    /*@PostMapping(value="/refresh",consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthResponse> refreshUser(@Valid @RequestBody RefreshInput refreshInput) throws Exception {
        if(refreshInput == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        AuthResponse authResponse = authService.refresh(refreshInput);
        if (!authResponse.success)
            return new ResponseEntity<>(authResponse, HttpStatus.NOT_FOUND);

        return getAuthResponseResponseEntity(authResponse);
    }*/

    /*
    private ResponseEntity<?> getAuthResponseResponseEntity(AuthResponse authResponse) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Auth-Token", authResponse.getResource().getToken());
        //responseHeaders.add("Refresh-Token", authResponse.getResource().getRefreshToken());

        //authResponse.getResource().setRefreshToken(null);
        authResponse.getResource().setToken(null);
        return new ResponseEntity<>(authResponse,responseHeaders, HttpStatus.OK);
    }
    */

}