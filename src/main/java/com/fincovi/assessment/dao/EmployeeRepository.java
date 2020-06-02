package com.fincovi.assessment.dao;

import com.fincovi.assessment.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,String > {

}
