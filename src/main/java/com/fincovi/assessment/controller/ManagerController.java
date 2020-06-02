package com.fincovi.assessment.controller;


import com.fincovi.assessment.manager.DepartmentLanguageManager;
import com.fincovi.assessment.resource.DepartmentLanguageResource;
import com.fincovi.assessment.resource.ResponseResource;
import com.fincovi.assessment.utils.ResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/manager")
public class ManagerController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DepartmentLanguageManager departmentLanguageManager;

    @GetMapping("/")
    public HttpEntity<ResponseResource> getALl() {
        LOGGER.info("start of the " + ManagerController.class.getName() + " getALl() method");
        List<DepartmentLanguageResource> departmentLanguageResources = departmentLanguageManager.getAll();
        LOGGER.info("end of the " + ManagerController.class.getName() + " getALl() method");
        return ResponseBuilder.build(departmentLanguageResources, HttpStatus.OK);
    }

    @GetMapping("/departments/{departmentId}/languages/{languageId}")
    public HttpEntity<ResponseResource> getByIds(@PathVariable String departmentId,
                                                 @PathVariable String languageId) {
        LOGGER.info("start of the " + ManagerController.class.getName() + " getByIds() method");
        DepartmentLanguageResource departmentLanguageResources = departmentLanguageManager.getByIds(departmentId, languageId);
        LOGGER.info("end of the " + ManagerController.class.getName() + " getByIds() method");
        return ResponseBuilder.build(departmentLanguageResources, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/manage")
    public HttpEntity<ResponseResource> linkDepartmentAndLanguage(
            @RequestBody DepartmentLanguageResource departmentLanguageResource
    ) {
        LOGGER.info("start of the " + ManagerController.class.getName() + " linkDepartmentAndLanguage() method");
        departmentLanguageResource = departmentLanguageManager.linkDepartmentAndLanguage(departmentLanguageResource);
        LOGGER.info("end of the " + ManagerController.class.getName() + " linkDepartmentAndLanguage() method");
        return ResponseBuilder.build(departmentLanguageResource, HttpStatus.OK);
    }
}
