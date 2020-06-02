package com.fincovi.assessment.manager;

import com.fincovi.assessment.resource.DepartmentLanguageResource;

import java.util.List;

public interface DepartmentLanguageManager {
    public DepartmentLanguageResource linkDepartmentAndLanguage(DepartmentLanguageResource departmentLanguageResource);

    List<DepartmentLanguageResource> getAll();

    DepartmentLanguageResource getByIds(String departmentId,String languageId);
}
