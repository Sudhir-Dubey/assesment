package com.fincovi.assessment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "language")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Language  implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",
            strategy = "uuid")
    private String id;
    private String name;
    private String code;

    @OneToMany(
            mappedBy = "language",
            cascade = {CascadeType.PERSIST,CascadeType.MERGE},
            orphanRemoval = true
    )
    @JsonIgnore
    private List<DepartmentLanguage> departmentLanguages = new ArrayList<>();

    public Language() {
    }

    public Language(String id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DepartmentLanguage> getDepartmentLanguages() {
        return departmentLanguages;
    }

    public void setDepartmentLanguages(List<DepartmentLanguage> departmentLanguages) {
        this.departmentLanguages = departmentLanguages;
    }
}
