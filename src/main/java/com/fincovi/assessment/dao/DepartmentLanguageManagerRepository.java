package com.fincovi.assessment.dao;

import com.fincovi.assessment.domain.DepartmentLanguage;
import com.fincovi.assessment.domain.DepartmentLanguageId;
import com.fincovi.assessment.exception.OperationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public interface DepartmentLanguageManagerRepository extends JpaRepository<DepartmentLanguage, DepartmentLanguageId> {


    default DepartmentLanguage getByIds(DepartmentLanguageId id){
        Optional<DepartmentLanguage> optionalDepartmentLanguage = findById(id);
        optionalDepartmentLanguage.orElseThrow(()-> new OperationException("DepartmentLanguage is not found",HttpStatus.NOT_FOUND) );
        DepartmentLanguage departmentLanguage = optionalDepartmentLanguage.get();
        return departmentLanguage;
    }

}
