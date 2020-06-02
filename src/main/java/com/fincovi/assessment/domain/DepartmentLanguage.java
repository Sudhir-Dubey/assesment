package com.fincovi.assessment.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity()
@Table(name = "department_language")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DepartmentLanguage {

    @EmbeddedId
    private DepartmentLanguageId id=new DepartmentLanguageId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("departmentId")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("languageId")
    private Language language;

    @Column(name = "description")
    private String description;

    @Column(name = "created_on")
    private Date createdOn = new Date();




    public DepartmentLanguage() {
    }

    public DepartmentLanguage(DepartmentLanguageId id, Department department, Language language, Date createdOn,String description) {
        this.id = id;
        this.department = department;
        this.language = language;
        this.createdOn = createdOn;
        this.description=description;
    }

    public DepartmentLanguageId getId() {
        return id;
    }

    public void setId(DepartmentLanguageId id) {
        this.id = id;
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        DepartmentLanguage that = (DepartmentLanguage) o;
        return Objects.equals(department, that.department) &&
                Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department, language);
    }
}
