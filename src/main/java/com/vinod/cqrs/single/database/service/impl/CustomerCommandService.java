package com.vinod.cqrs.single.database.service.impl;

import com.vinod.cqrs.single.database.dto.CustomerRegisterCommandDto;
import com.vinod.cqrs.single.database.model.Customer;
import com.vinod.cqrs.single.database.repository.CustomerRepository;
import com.vinod.cqrs.single.database.service.ICustomerCommandService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerCommandService implements ICustomerCommandService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Add customer object to database.
     *
     * @param customerRegisterCommandDto - Customer register command object.
     */
    @Override
    public void addCustomer(CustomerRegisterCommandDto customerRegisterCommandDto) {
        log.trace("Request came to add new customer : {}", customerRegisterCommandDto);
        modelMapper.addMappings(new PropertyMap<CustomerRegisterCommandDto, Customer>() {
            @Override
            protected void configure() {
                skip(destination.getId());
            }
        });
        Customer customer = modelMapper.map(customerRegisterCommandDto, Customer.class);
        customer.setEnabled(true);
        customerRepository.save(customer);
        log.trace("Successfully saved customer object for: {}", customerRegisterCommandDto);
    }
}
