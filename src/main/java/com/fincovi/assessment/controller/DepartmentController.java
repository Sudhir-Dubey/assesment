package com.fincovi.assessment.controller;

import com.fincovi.assessment.resource.DepartmentResource;
import com.fincovi.assessment.resource.ResponseResource;
import com.fincovi.assessment.service.DepartmentService;
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
@RequestMapping("v1/departments")
public class  DepartmentController {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/health")
    public HttpEntity<ResponseResource> health() {

        return ResponseBuilder.build("I am alive", HttpStatus.OK);
    }

    @GetMapping("/")
    public HttpEntity<ResponseResource> getDepartments() {
        List<DepartmentResource> departmentResources = departmentService.getAll();
        return ResponseBuilder.build(departmentResources, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<ResponseResource> get(@PathVariable String id) {
        DepartmentResource departmentResource = departmentService.get(id);
        return ResponseBuilder.build(departmentResource, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/")
    public HttpEntity<ResponseResource> create(@RequestBody DepartmentResource departmentResource) {
        departmentResource = departmentService.create(departmentResource);

        return ResponseBuilder.build(departmentResource, HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<ResponseResource> update(@PathVariable String id, @RequestBody DepartmentResource departmentResource) {
        departmentResource = departmentService.update(departmentResource);
        return ResponseBuilder.build(departmentResource, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<ResponseResource> delete(@PathVariable String id) {
        String message = departmentService.delete(id);
        return ResponseBuilder.build(message, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/{departmentId}/employees/{employeeId}")
    public HttpEntity<ResponseResource> addEmployeeToDepartment(@PathVariable String departmentId, @PathVariable String employeeId) {
        DepartmentResource departmentResource = departmentService.addEmployee(departmentId, employeeId);

        return ResponseBuilder.build(departmentResource, HttpStatus.OK);
    }
}
