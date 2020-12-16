package com.vinod.cqrs.single.database.service;

import com.vinod.cqrs.single.database.dto.CustomerQueryDto;

public interface ICustomerQueryService {

    /**
     * Get customer object by customer id.
     *
     * @param id    - Customer ID.
     * @return      - Customer query object.
     */
    CustomerQueryDto getCustomerById(Long id);
}
