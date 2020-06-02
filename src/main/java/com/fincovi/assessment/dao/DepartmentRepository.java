package com.fincovi.assessment.dao;

import com.fincovi.assessment.domain.Department;
import com.fincovi.assessment.exception.OperationException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DepartmentRepository extends CrudRepository<Department,String > {

    default  Department getDepartment(String id){
        Optional<Department> optionalDepartment = findById(id);
        optionalDepartment.orElseThrow(() -> new OperationException("Department is not found ",
                HttpStatus.NOT_FOUND));
      return  optionalDepartment.get();
    }

}