package com.fincovi.assessment.controller;

import com.fincovi.assessment.resource.EmployeeResource;
import com.fincovi.assessment.resource.ResponseResource;
import com.fincovi.assessment.service.EmployeeService;
import com.fincovi.assessment.utils.ResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/employees")
public class EmployeeController {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/health")
    public HttpEntity<String> ping() {
        return new ResponseEntity("I am alive", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<ResponseResource> getEmployee(@PathVariable String id) {
        EmployeeResource employeeResource = employeeService.get(id);

        return ResponseBuilder.build(employeeResource, HttpStatus.OK);
    }

    @GetMapping("/")
    public HttpEntity<ResponseResource> getEmployees() {
        List<EmployeeResource> employeeResources = employeeService.getAll();
        return ResponseBuilder.build(employeeResources, HttpStatus.OK);
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public HttpEntity<ResponseResource> create(@RequestBody EmployeeResource employeeResource) {
        employeeResource = employeeService.create(employeeResource);
        return ResponseBuilder.build(employeeResource, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public HttpEntity<ResponseResource> update(@PathVariable String id, @RequestBody EmployeeResource employeeResource) {
        employeeResource = employeeService.update(employeeResource);
        return ResponseBuilder.build(employeeResource, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public HttpEntity<ResponseResource> delete(@PathVariable String id) {
        String message = employeeService.delete(id);
        return ResponseBuilder.build(message, HttpStatus.OK);
    }

}
