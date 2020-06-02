package com.fincovi.assessment.builder;

import com.fincovi.assessment.resource.EmployeeResource;

/**
 * assessment
 *
 * @author <<sudhir dubey>>
 * @copyright Copyright (c) 2020 - fincovi - All Rights Reserved
 * @since may 22, 2020
 */



public class EmployeeBuilder
{
    private EmployeeResource _entity = new EmployeeResource();
    public EmployeeBuilder Id(String id)
    {
        _entity.setId(id);
        return this;
    }

    public EmployeeBuilder firstName(String firstName)
    {
        _entity.setFirstName(firstName);
        return this;
    }

    public EmployeeBuilder lastName(String lastName)
    {
        _entity.setLastName(lastName);
        return this;
    }

    public EmployeeResource build()
    {
        return _entity;
    }


    public EmployeeBuilder withTestValues()
    {
        _entity = new EmployeeResource();

        return this;
    }
}