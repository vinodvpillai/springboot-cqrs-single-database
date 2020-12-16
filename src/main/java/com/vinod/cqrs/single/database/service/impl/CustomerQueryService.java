package com.vinod.cqrs.single.database.service.impl;

import com.vinod.cqrs.single.database.dto.CustomerQueryDto;
import com.vinod.cqrs.single.database.model.Customer;
import com.vinod.cqrs.single.database.repository.CustomerRepository;
import com.vinod.cqrs.single.database.service.ICustomerQueryService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class CustomerQueryService implements ICustomerQueryService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Get customer object by customer id.
     *
     * @param id    - Customer ID.
     * @return      - Customer query object.
     */
    @Override
    public CustomerQueryDto getCustomerById(Long id) {
        log.trace("Request came to fetch the customer having customer id : {}",id);
        Optional<Customer> optionalCustomer=customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
            Customer customer=optionalCustomer.get();
            CustomerQueryDto customerQueryDto=modelMapper.map(customer,CustomerQueryDto.class);
            log.trace("Successfully fetched customer object : {} having customer id: {}",customerQueryDto,id);
            return customerQueryDto;
        }
        return null;
    }
}
