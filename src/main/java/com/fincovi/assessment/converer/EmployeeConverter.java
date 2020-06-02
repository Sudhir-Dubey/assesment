package com.fincovi.assessment.converer;

import com.fincovi.assessment.domain.Employee;
import com.fincovi.assessment.resource.EmployeeResource;
import org.springframework.stereotype.Component;

@Component()
public class EmployeeConverter implements GenericConverter<Employee, EmployeeResource> {

    @Override
    public Employee toDomain(EmployeeResource resource) {
        Employee employee = new Employee(resource.getId(), resource.getFirstName(), resource.getLastName());
        return employee;
    }

    @Override
    public EmployeeResource toResource(Employee domain) {
        EmployeeResource employeeResource = new EmployeeResource(domain.getId(), domain.getFirstName(), domain.getLastName());
        return employeeResource;
    }
}
