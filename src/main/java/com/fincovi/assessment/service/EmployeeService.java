package com.fincovi.assessment.service;

import com.fincovi.assessment.resource.EmployeeResource;

import java.util.List;

public interface EmployeeService {
    public EmployeeResource create(EmployeeResource employeeResource);

    public EmployeeResource update(EmployeeResource employeeResource);

    public String delete(String id);

    public EmployeeResource get(String id);

    public List<EmployeeResource> getAll();

    public List<EmployeeResource> search(EmployeeResource departmentResource);


}
