package com.fincovi.assessment.builder;

import com.fincovi.assessment.resource.DepartmentResource;
import com.fincovi.assessment.resource.EmployeeResource;

/**
 * assessment
 *
 * @author <<sudhir dubey>>
 * @copyright Copyright (c) 2020 - fincovi - All Rights Reserved
 * @since may 22, 2020
 */



public class DepartmentBuilder
{
    private DepartmentResource _entity = new DepartmentResource();
    public DepartmentBuilder id(String id)
    {
        _entity.setId(id);
        return this;
    }

    public DepartmentBuilder locationId(String locationId)
    {
        _entity.setLocationId(locationId);
        return this;
    }

    public DepartmentBuilder status(String status)
    {
        _entity.setStatus(status);
        return this;
    }




    public DepartmentResource build()
    {
        return _entity;
    }

    public DepartmentBuilder withTestValues()
    {
        _entity = new DepartmentResource();

        return this;
    }
}