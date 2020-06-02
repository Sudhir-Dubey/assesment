package com.fincovi.assessment.controller;
/**
 * assessment
 *
 * @author <<sudhir dubey>>
 * @copyright Copyright (c) 2020 - fincovi - All Rights Reserved
 * @since may 22, 2020
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fincovi.assessment.builder.EmployeeBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext applicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.applicationContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void createEmployeeTest() throws Exception {
        EmployeeBuilder employeeBuilder = new EmployeeBuilder();

        this.mockMvc
                .perform(
                        post("/v1/employees/")
                                .content(this.objectMapper.writeValueAsBytes(employeeBuilder
                                        .withTestValues()
                                        .firstName("Jayesh")
                                        .lastName("Shah")
                                        .build()
                                ))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isForbidden());

    }


}