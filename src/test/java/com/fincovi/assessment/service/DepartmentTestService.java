package com.fincovi.assessment.service;

import com.fincovi.assessment.builder.DepartmentBuilder;
import com.fincovi.assessment.exception.OperationException;
import com.fincovi.assessment.resource.DepartmentResource;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.management.OperationsException;

import static org.junit.Assert.assertEquals;

/**
 * assessment
 *
 * @author <<sudhir dubey>>
 * @copyright Copyright (c) 2020 - fincovi - All Rights Reserved
 * @since may 22, 2020
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentTestService {
    DepartmentBuilder builder = new DepartmentBuilder();
    DepartmentResource departmentResource;


    @Autowired
    private DepartmentService departmentService;


    @Test
    @Order(1)
    public void testCreateDepartment() {
        departmentResource = builder.withTestValues().locationId("Hyderabd").status("Active").build();
        departmentResource = departmentService.create(this.departmentResource);
        Assert.assertNotNull(departmentResource.getId());

    }



    @Test()
    @Order(3)
    public void testGetDepartmentByInvalidId() {
        try
        {
            DepartmentResource newDepartmentResource = departmentService.get("hsdjhfajsd");
        }
        catch( OperationException e )
        {
            final String msg = "Department is not found ";
            assertEquals(msg, e.getMessage());
        }
    }

}
