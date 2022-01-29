package com.naman.springmvcrest.api.v1.controllers;

import com.naman.springmvcrest.model.CustomerDTO;
import com.naman.springmvcrest.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static com.naman.springmvcrest.api.v1.controllers.AbstractRestControllerTest.asJsonString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CustomerControllerTest {

    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Doe";

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllCustomers() throws Exception {

        when(customerService.getAllCustomers())
                .thenReturn(Arrays.asList(new CustomerDTO(), new CustomerDTO()));

        mockMvc.perform(get(CustomerDTO.BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customers", hasSize(2)));
    }

    @Test
    void getCustomerById() {
    }

    @Test
    void createNewCustomer() {
    }

    @Test
    void updateCustomer() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(FIRST_NAME);
        customerDTO.setLastName(LAST_NAME);

        CustomerDTO returnDTO = new CustomerDTO();
        returnDTO.setFirstName(customerDTO.getFirstName());
        returnDTO.setLastName(customerDTO.getLastName());
        returnDTO.setCustomerUrl(CustomerDTO.BASE_URL + "/1");

        when(customerService.updateCustomerById(anyLong(), any(CustomerDTO.class)))
                .thenReturn(returnDTO);

        mockMvc.perform(put(CustomerDTO.BASE_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(customerDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname", equalTo(FIRST_NAME)))
                .andExpect(jsonPath("$.lastname", equalTo(LAST_NAME)))
                .andExpect(jsonPath("$.customer_url", equalTo(CustomerDTO.BASE_URL + "/1")));

    }

    @Test
    void patchCustomer() {
    }
}