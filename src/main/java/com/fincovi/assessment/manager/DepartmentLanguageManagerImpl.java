package com.fincovi.assessment.manager;

import com.fincovi.assessment.dao.DepartmentLanguageManagerRepository;
import com.fincovi.assessment.dao.DepartmentRepository;
import com.fincovi.assessment.dao.LanguageRepository;
import com.fincovi.assessment.domain.Department;
import com.fincovi.assessment.domain.DepartmentLanguage;
import com.fincovi.assessment.domain.DepartmentLanguageId;
import com.fincovi.assessment.domain.Language;
import com.fincovi.assessment.resource.DepartmentLanguageResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentLanguageManagerImpl implements DepartmentLanguageManager {
    @Autowired
    private DepartmentLanguageManagerRepository departmentLanguageManagerRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    //@Transactional
    public DepartmentLanguageResource linkDepartmentAndLanguage(DepartmentLanguageResource departmentLanguageResource) {


        try {

            Department department = departmentLanguageResource.getDepartment();
            Language language = departmentLanguageResource.getLanguage();
            DepartmentLanguage departmentLanguage = new DepartmentLanguage();
            departmentLanguage.setDepartment(department);
            departmentLanguage.setLanguage(language);
            departmentLanguage.setDescription(departmentLanguageResource.getDescription());
            language.getDepartmentLanguages().add(departmentLanguage);
            department.getDepartmentLanguages().add(departmentLanguage);
            department = departmentRepository.save(department);
            language = languageRepository.save(language);
            departmentLanguageManagerRepository.saveAndFlush(departmentLanguage);

            departmentLanguageResource.setDepartment(department);
            departmentLanguageResource.setLanguage(language);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return departmentLanguageResource;
    }

    @Override
    public List<DepartmentLanguageResource> getAll() {

        List<DepartmentLanguage> departmentLanguages = departmentLanguageManagerRepository.findAll();
        List<DepartmentLanguageResource> departmentLanguageResources = departmentLanguages
                .stream().map(departmentLanguage -> {
            DepartmentLanguageResource departmentLanguageResource = new DepartmentLanguageResource();
            departmentLanguageResource.setLanguage(departmentLanguage.getLanguage());
            departmentLanguageResource.setDepartment(departmentLanguage.getDepartment());
            departmentLanguageResource.setDescription(departmentLanguage.getDescription());
            return departmentLanguageResource;
        }).collect(Collectors.toList());


        return departmentLanguageResources;
    }

    @Override
    public DepartmentLanguageResource getByIds(String departmentId, String languageId) {
        DepartmentLanguageId departmentLanguageId = new DepartmentLanguageId(departmentId, languageId);
        DepartmentLanguage departmentLanguage = departmentLanguageManagerRepository.getByIds(departmentLanguageId);
        DepartmentLanguageResource departmentLanguageResource = new DepartmentLanguageResource();
        departmentLanguageResource.setDescription(departmentLanguage.getDescription());
        departmentLanguageResource.setDepartment(departmentLanguage.getDepartment());
        departmentLanguageResource.setLanguage(departmentLanguage.getLanguage());
        return departmentLanguageResource;
    }
}
