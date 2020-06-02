package com.fincovi.assessment.resource;

public class EmployeeResource {
    private String id;
    private String firstName;
    private String lastName;
    private DepartmentResource departmentResource;


    public EmployeeResource() {

    }

    public EmployeeResource(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    EmployeeResource(String id, String firstName, String lastName, DepartmentResource departmentResource) {
        this(id, firstName, lastName);
        this.departmentResource = departmentResource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DepartmentResource getDepartmentResource() {
        return departmentResource;
    }

    public void setDepartmentResource(DepartmentResource departmentResource) {
        this.departmentResource = departmentResource;
    }
}
