package com.naman.springmvcrest.mapper;

import com.naman.springmvcrest.domain.Customer;
import com.naman.springmvcrest.model.CustomerDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {

    public static final Long ID = 1L;
    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Doe";

    CustomerMapper mapper = CustomerMapper.INSTANCE;

    @Test
    void customerToCustomerDTO() {

        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);

        CustomerDTO actualCustomerDTO = mapper.customerToCustomerDTO(customer);

        assertEquals(FIRST_NAME, actualCustomerDTO.getFirstName());
        assertEquals(LAST_NAME, actualCustomerDTO.getLastName());

    }

    @Test
    void customerDTOToCustomer() {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(FIRST_NAME);
        customerDTO.setLastName(LAST_NAME);

        Customer customer = mapper.customerDTOToCustomer(customerDTO);

        assertEquals(FIRST_NAME, customer.getFirstName());
        assertEquals(LAST_NAME, customer.getLastName());

    }
}