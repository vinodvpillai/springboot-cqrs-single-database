package com.vinod.cqrs.single.database.controller;

import com.vinod.cqrs.single.database.dto.CustomerQueryDto;
import com.vinod.cqrs.single.database.service.ICustomerQueryService;
import com.vinod.springboot.liquibase.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.vinod.springboot.liquibase.util.GlobalUtility.buildResponseForError;
import static com.vinod.springboot.liquibase.util.GlobalUtility.buildResponseForSuccess;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerQueryRestController {

    @Autowired
    private ICustomerQueryService customerQueryService;

    @GetMapping("/{id}")
    public ResponseEntity<Response> getCustomer(@PathVariable("id") Long id) {
        log.trace("Request came to get the customer details having the id: {}", id);
        CustomerQueryDto customerQueryDto=customerQueryService.getCustomerById(id);
        if(null!=customerQueryDto) {
            return buildResponseForSuccess(HttpStatus.SC_OK,"Successfully fetched customer",customerQueryDto);
        }
        return buildResponseForError(HttpStatus.SC_BAD_REQUEST, String.valueOf(HttpStatus.SC_BAD_REQUEST),"No customer detail found for the given id.",null);
    }

}
