package com.vinod.cqrs.single.database.controller;

import com.vinod.cqrs.single.database.dto.CustomerRegisterCommandDto;
import com.vinod.cqrs.single.database.service.ICustomerCommandService;
import com.vinod.springboot.liquibase.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.vinod.springboot.liquibase.util.GlobalUtility.buildResponseForError;
import static com.vinod.springboot.liquibase.util.GlobalUtility.buildResponseForSuccess;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerCommandRestController {

    @Autowired
    private ICustomerCommandService customerCommandService;

    @PostMapping
    public ResponseEntity<Response> addNewCustomer(@RequestBody CustomerRegisterCommandDto customerRegisterCommandDto) {
        try{
            log.trace("Request came to add new customer with following details: {}", customerRegisterCommandDto);
            customerCommandService.addCustomer(customerRegisterCommandDto);
            return buildResponseForSuccess(HttpStatus.SC_OK,"Successfully added the customer details.",null);
        } catch (Exception e) {
            log.error("Exception occurred while adding the customer details, error msg: {}",e.getMessage(), e);
            return buildResponseForError(HttpStatus.SC_INTERNAL_SERVER_ERROR, String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR),"Unable to add the customer details.",null);
        }
    }
}
