package com.fincovi.assessment.resource;

/**
 *
 * assessment
 *
 * @author sudhir kumar dubey
 * @since May 22, 2020
 * @copyright Copyright (c) 2020 - Fincovi - All Rights Reserved
 */

import java.util.List;

public class DepartmentResource {

    private String id;
    private String locationId;
    private String status;

    private List<EmployeeResource> employees;

    public DepartmentResource() {
    }

    public DepartmentResource(String id, String locationId, String status) {
        this.id = id;
        this.locationId = locationId;
        this.status = status;

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


    public List<EmployeeResource> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeResource> employees) {
        this.employees = employees;
    }


}
