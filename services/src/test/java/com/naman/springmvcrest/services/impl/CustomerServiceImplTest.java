package com.naman.springmvcrest.services.impl;

import com.naman.springmvcrest.domain.Customer;
import com.naman.springmvcrest.mapper.CustomerMapper;
import com.naman.springmvcrest.model.CustomerDTO;
import com.naman.springmvcrest.repositories.CustomerRepository;
import com.naman.springmvcrest.services.CustomerService;
import com.naman.springmvcrest.services.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class CustomerServiceImplTest {

    public static final Long ID = 1L;
    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Doe";

    CustomerMapper mapper = CustomerMapper.INSTANCE;

    @Mock
    CustomerRepository customerRepository;

    CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customerService = new CustomerServiceImpl(mapper, customerRepository);
    }

    @Test
    void getAllCustomers() {
        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();
        assertEquals(3, customerDTOS.size());
    }

    @Test
    void getCustomerById() {

        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);

        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));

        CustomerDTO customerDTO =  customerService.getCustomerById(ID);

        assertEquals(FIRST_NAME, customerDTO.getFirstName());
        assertEquals(LAST_NAME, customerDTO.getLastName());
    }

    @Test
    void createNewCustomer() {

        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);

        when(customerRepository.save(any())).thenReturn(customer);

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(FIRST_NAME);
        customerDTO.setLastName(LAST_NAME);

        CustomerDTO savedCustomerDTO = customerService.createNewCustomer(customerDTO);

        assertEquals(FIRST_NAME, savedCustomerDTO.getFirstName());
        assertEquals(LAST_NAME, savedCustomerDTO.getLastName());
        assertEquals(CustomerDTO.BASE_URL + "/1", savedCustomerDTO.getCustomerUrl());
    }

    @Test
    void updateCustomerById() {

        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstName("Alice");
        customer.setLastName(LAST_NAME);

        when(customerRepository.save(any())).thenReturn(customer);

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Alice");
        customerDTO.setLastName(LAST_NAME);

        CustomerDTO savedCustomerDTO = customerService.updateCustomerById(ID, customerDTO);

        assertEquals("Alice", savedCustomerDTO.getFirstName());
        assertEquals(LAST_NAME, savedCustomerDTO.getLastName());
        assertEquals(CustomerDTO.BASE_URL + "/1", savedCustomerDTO.getCustomerUrl());
    }

    @Test
    void deleteCustomerById() {

        customerService.deleteCustomerById(ID);

        verify(customerRepository, times(1)).deleteById(anyLong());

    }
}