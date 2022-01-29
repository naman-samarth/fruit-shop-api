package com.naman.springmvcrest.services.impl;

import com.naman.springmvcrest.domain.Customer;
import com.naman.springmvcrest.mapper.CustomerMapper;
import com.naman.springmvcrest.model.CustomerDTO;
import com.naman.springmvcrest.repositories.CategoryRepository;
import com.naman.springmvcrest.repositories.CustomerRepository;
import com.naman.springmvcrest.repositories.VendorRepository;
import com.naman.springmvcrest.services.CustomerService;
import com.naman.springmvcrest.services.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import({
        CustomerRepository.class,
        CategoryRepository.class,
        VendorRepository.class,
})
@Disabled
class CustomerServiceImplITest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    VendorRepository vendorRepository;

    CustomerService customerService;

    @BeforeEach
    void setUp() {
        System.out.println("Loading Customer Data");
        System.out.println(customerRepository.findAll().size());

//        DataLoader bootstrap = new DataLoader(
//                categoryRepository,
//                customerRepository,
//                vendorRepository);
//
//        bootstrap.run();

        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    void patchCustomerUpdateFirstName() {
        String updatedFirstName = "UpdatedName";
        Long id = getCustomerId();

        Customer origCustomer = customerRepository.getById(id);
        assertNotNull(origCustomer);
        String origFirstName = origCustomer.getFirstName();
        String origLastName = origCustomer.getLastName();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(updatedFirstName);

        customerService.patchCustomerById(id, customerDTO);

        Customer updatedCustomer = customerRepository.findById(id).get();

        assertNotNull(updatedCustomer);
        assertEquals(updatedFirstName, updatedCustomer.getFirstName());
        assertNotEquals(origFirstName, updatedCustomer.getFirstName());
        assertEquals(origLastName, updatedCustomer.getLastName());
    }

    @Test
    void patchCustomerUpdateLastName() {
        String updatedLastName = "UpdatedName";
        Long id = getCustomerId();

        Customer origCustomer = customerRepository.getById(id);
        assertNotNull(origCustomer);
        String origFirstName = origCustomer.getFirstName();
        String origLastName = origCustomer.getLastName();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setLastName(updatedLastName);

        customerService.patchCustomerById(id, customerDTO);

        Customer updatedCustomer = customerRepository.findById(id).get();

        assertNotNull(updatedCustomer);
        assertEquals(origFirstName, updatedCustomer.getFirstName());
        assertNotEquals(origLastName, updatedCustomer.getLastName());
        assertEquals(updatedLastName, updatedCustomer.getLastName());
    }

    private Long getCustomerId() {
        List<Customer> customers = customerRepository.findAll();
        System.out.println("Customers Found: " + customers.size());

        return customers.get(0).getId();
    }
}