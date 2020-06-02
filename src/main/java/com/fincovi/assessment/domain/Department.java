package com.fincovi.assessment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "department")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",
            strategy = "uuid")
    private String id;
    private String locationId;
    private String status;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    public Department() {
    }

    @OneToMany(
            mappedBy = "department",
            cascade = {PERSIST, MERGE,},
            orphanRemoval = true
    )
    //  @JsonIgnore
    @JsonIgnore
    private List<DepartmentLanguage> departmentLanguages = new ArrayList<>();


    public Department(String id, String locationId, String status) {
        this.id = id;
        this.locationId = locationId;
        this.status = status;

    }

    public Department(String id, String locationId, String status, List<Employee> employees) {
        this.id = id;
        this.locationId = locationId;
        this.status = status;

        this.employees = employees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


    public List<DepartmentLanguage> getDepartmentLanguages() {
        return departmentLanguages;
    }

    public void setDepartmentLanguages(List<DepartmentLanguage> departmentLanguages) {
        this.departmentLanguages = departmentLanguages;
    }
}
