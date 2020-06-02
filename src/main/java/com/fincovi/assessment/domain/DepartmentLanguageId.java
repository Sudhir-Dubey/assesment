package com.fincovi.assessment.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DepartmentLanguageId
        implements Serializable {

    //@Column(name = "departmentId")
    private String departmentId;

   // @Column(name = "language_id")
    private String languageId;


    public DepartmentLanguageId() {}

    public DepartmentLanguageId(String departmentId, String languageId) {
        this.departmentId = departmentId;
        this.languageId = languageId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentLanguageId that = (DepartmentLanguageId) o;
        return Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(languageId, that.languageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, languageId);
    }
}