package com.fincovi.assessment.service.impl;

import com.fincovi.assessment.converer.DepartmentConverter;
import com.fincovi.assessment.converer.EmployeeConverter;
import com.fincovi.assessment.dao.DepartmentRepository;
import com.fincovi.assessment.dao.EmployeeRepository;
import com.fincovi.assessment.domain.Department;
import com.fincovi.assessment.domain.Employee;
import com.fincovi.assessment.exception.OperationException;
import com.fincovi.assessment.resource.DepartmentResource;
import com.fincovi.assessment.resource.EmployeeResource;
import com.fincovi.assessment.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentConverter departmentConverter;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeConverter employeeConverter;

    @Override
    public DepartmentResource create(DepartmentResource departmentResource) {
        Department department = departmentConverter.toDomain(departmentResource);
        department = departmentRepository.save(department);
        departmentResource = departmentConverter.toResource(department);
        return departmentResource;
    }

    @Override
    public DepartmentResource update(DepartmentResource departmentResource) {
        Department department = departmentConverter.toDomain(departmentResource);
        department = departmentRepository.save(department);
        departmentResource = departmentConverter.toResource(department);
        return departmentResource;
    }

    @Override
    public String delete(String id) {
        try {
            departmentRepository.deleteById(id);
            String result = String.format("Department with id %s deleted successfully", id);
            return result;
        } catch (EmptyResultDataAccessException ex) {

            LOGGER.error(ex.getMessage());
            throw new OperationException(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public DepartmentResource get(String id) {
        DepartmentResource departmentResource = departmentConverter.toResource(departmentRepository.getDepartment(id));
        return departmentResource;
    }

    @Override
    public List<DepartmentResource> getAll() {
        Iterable<Department> departmentIterable = departmentRepository.findAll();
        List<DepartmentResource> departments = new ArrayList<>();
        if (departmentIterable != null) {
            departmentIterable.forEach(department -> {
                DepartmentResource departmentResource = departmentConverter.toResource(department);
                departments.add(departmentResource);
            });
        }
        return departments;
    }

    @Override
    public List<DepartmentResource> search(DepartmentResource departmentResource) {
        return null;
    }

    @Override
    public DepartmentResource addEmployee(String departmentId, String employeeId) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        optionalDepartment.orElseThrow(() -> new OperationException(
                String.format("department with %s not found ", departmentId), HttpStatus.NOT_FOUND));
        Department department = optionalDepartment.get();
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

        Employee employee = optionalEmployee.get();
        employee.setDepartment(department);
        employeeRepository.save(employee);
        optionalDepartment = departmentRepository.findById(departmentId);
        department = optionalDepartment.get();
        DepartmentResource departmentResource = departmentConverter.toResource(department);
        List<Employee> employees = department.getEmployees();
        List<EmployeeResource> employeeResources = employees
                .stream()
                .map(emp ->
                        employeeConverter.toResource(emp))
                .collect(Collectors.toList());
        departmentResource.setEmployees(employeeResources);
        return departmentResource;
    }
}
