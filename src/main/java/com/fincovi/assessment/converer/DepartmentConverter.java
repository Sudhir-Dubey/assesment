package com.fincovi.assessment.converer;

import com.fincovi.assessment.domain.Department;
import com.fincovi.assessment.resource.DepartmentResource;
import org.springframework.stereotype.Component;

@Component()
public class DepartmentConverter implements GenericConverter<Department, DepartmentResource> {

    @Override
    public Department toDomain(DepartmentResource resource) {
        Department department = new Department(resource.getId(), resource.getLocationId(), resource.getStatus());
        return department;
    }

    @Override
    public DepartmentResource toResource(Department domain) {
        DepartmentResource departmentResource = new DepartmentResource(domain.getId(), domain.getLocationId(), domain.getStatus() );
        return departmentResource;
    }
}
