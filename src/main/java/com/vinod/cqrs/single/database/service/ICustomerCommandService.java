package com.vinod.cqrs.single.database.service;

import com.vinod.cqrs.single.database.dto.CustomerRegisterCommandDto;

public interface ICustomerCommandService {

    /**
     * Add customer object to database.
     *
     * @param customerRegisterCommandDto - Customer register command object.
     */
    void addCustomer(CustomerRegisterCommandDto customerRegisterCommandDto);
}
