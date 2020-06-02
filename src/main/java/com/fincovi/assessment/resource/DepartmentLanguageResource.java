package com.fincovi.assessment.resource;

import com.fincovi.assessment.domain.Department;
import com.fincovi.assessment.domain.Language;

public class DepartmentLanguageResource {

    private Department department;
    private Language language;
    private String description;

    public DepartmentLanguageResource() {
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
