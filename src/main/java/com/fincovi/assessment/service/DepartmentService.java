package com.fincovi.assessment.service;

import com.fincovi.assessment.resource.DepartmentResource;

import java.util.List;

public interface DepartmentService {
    public DepartmentResource create(DepartmentResource departmentResource);

    public DepartmentResource update(DepartmentResource departmentResource);

    public String delete(String id);

    public DepartmentResource get(String id);

    public List<DepartmentResource> getAll();

    public List<DepartmentResource> search(DepartmentResource departmentResource);

    public DepartmentResource addEmployee(String departmentId, String employeeId);

}
