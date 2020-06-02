package com.fincovi.assessment.repository;

import com.fincovi.assessment.dao.DepartmentRepository;
import com.fincovi.assessment.domain.Department;
import io.jsonwebtoken.lang.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * assessment
 *
 * @author <<sudhir dubey>>
 * @copyright Copyright (c) 2020 - fincovi - All Rights Reserved
 * @since may 22, 2020
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentTestRepository {
    private Department department;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testAddDepartment() {
        department = new Department(null, "Hyderabd", "Active");
        department = departmentRepository.save(department);
        Assert.notNull(department.getId());
    }
}
