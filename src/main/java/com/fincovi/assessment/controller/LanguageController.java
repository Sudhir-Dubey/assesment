package com.fincovi.assessment.controller;

import com.fincovi.assessment.resource.LanguageResource;
import com.fincovi.assessment.resource.ResponseResource;
import com.fincovi.assessment.service.LanguageService;
import com.fincovi.assessment.utils.ResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/languages")
public class LanguageController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LanguageService languageService;

    @GetMapping("/{id}")
    public HttpEntity<ResponseResource> getLanguage(@PathVariable String id) {
        return ResponseBuilder.build(languageService.get(id), HttpStatus.OK);

    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public HttpEntity<ResponseResource> createLanguage(@RequestBody LanguageResource languageResource) {
        return ResponseBuilder.build(languageService.create(languageResource), HttpStatus.OK);
    }

    // todo add delete, update and search mapping
}
