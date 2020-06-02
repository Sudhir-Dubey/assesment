package com.fincovi.assessment.service.impl;

import com.fincovi.assessment.converer.EmployeeConverter;
import com.fincovi.assessment.dao.EmployeeRepository;
import com.fincovi.assessment.domain.Employee;
import com.fincovi.assessment.exception.OperationException;
import com.fincovi.assessment.resource.EmployeeResource;
import com.fincovi.assessment.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeConverter employeeConverter;

    @Autowired
    private EntityManager entityManager;

    @Override
    public EmployeeResource create(EmployeeResource employeeResource) {
        // todo add assembler
        Employee employee = employeeConverter.toDomain(employeeResource);
        employee = employeeRepository.save(employee);
        employeeResource = employeeConverter.toResource(employee);
        return employeeResource;
    }

    @Override
    public EmployeeResource update(EmployeeResource employeeResource) {
        Employee employee = employeeConverter.toDomain(employeeResource);
        employeeRepository.save(employee);
        return employeeConverter.toResource(employee);
    }

    @Override
    public String delete(String id) {
        employeeRepository.deleteById(id);
        String result = String.format("Employee with id %s deleted successfully", id);
        return result;
    }

    @Override
    public EmployeeResource get(String id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        optionalEmployee.orElseThrow(
                () -> new OperationException("Employee  not found ", HttpStatus.NOT_FOUND));
        return employeeConverter.toResource(optionalEmployee.get());
    }

    @Override
    public List<EmployeeResource> getAll() {
        Iterable<Employee> employees = employeeRepository.findAll();
        List<EmployeeResource> employeeResources = new ArrayList<>();
        if (employees != null) {
            employees.forEach(employee -> {
                EmployeeResource employeeResource = employeeConverter.toResource(employee);
                employeeResources.add(employeeResource);
            });
        }
        return employeeResources;
    }

    @Override
    public List<EmployeeResource> search(EmployeeResource employeeResource) {

        return null;
    }
}
