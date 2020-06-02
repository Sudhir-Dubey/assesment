package com.fincovi.assessment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fincovi.assessment.builder.DepartmentBuilder;
import com.fincovi.assessment.domain.Role;
import com.fincovi.assessment.resource.DepartmentResource;
import com.fincovi.assessment.resource.ResponseResource;
import com.fincovi.assessment.resource.UserResource;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * assessment
 *
 * @author <<sudhir dubey>>
 * @copyright Copyright (c) 2020 - fincovi - All Rights Reserved
 * @since may 22, 2020
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DepartmentTestController {
    @Autowired
    private TestRestTemplate restTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();
    @LocalServerPort
    int port;
    String token;

    @Before
    public void getToken() throws URISyntaxException, JSONException {
        UserResource userResource = new UserResource();
        userResource.setEmail("sudhir@gmail.com");
        userResource.setPassword("skD@gamil.com");
        userResource.setUsername("skd");
        List<Role> roles = new ArrayList<>();
        roles.add(Role.ROLE_ADMIN);
        HttpEntity<UserResource> entity = new HttpEntity<>(userResource, null);

        userResource.setRoles(roles);
        ResponseEntity<ResponseResource> response = restTemplate.exchange(
                createURLWithPort("/users/signup"),
                HttpMethod.POST, entity, ResponseResource.class);
        token = (String) response.getBody().getData();
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void healthTest() throws URISyntaxException, JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<ResponseResource> response = restTemplate.exchange(
                createURLWithPort("v1/departments/health"),
                HttpMethod.GET, entity, ResponseResource.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("I am alive", response.getBody().getData());
    }


    @Test
    public void addDepartmentTest() throws URISyntaxException, JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        DepartmentBuilder departmentBuilder = new DepartmentBuilder();
        DepartmentResource departmentResource = departmentBuilder
                .withTestValues()
                .status("Active")
                .locationId("Mumbai")
                .build();
        HttpEntity<DepartmentResource> entity = new HttpEntity<>(departmentResource, headers);
        ResponseEntity<ResponseResource> response = restTemplate.exchange(
                createURLWithPort("v1/departments/"),
                HttpMethod.POST, entity, ResponseResource.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        departmentResource = (DepartmentResource) response.getBody().getData();
        Assert.assertNotNull(departmentResource.getId());

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}

