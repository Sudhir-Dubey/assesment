package com.fincovi.assessment.service.impl;

import com.fincovi.assessment.dao.LanguageRepository;
import com.fincovi.assessment.domain.Language;
import com.fincovi.assessment.resource.LanguageResource;
import com.fincovi.assessment.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public LanguageResource get(String id) {
        Language language = languageRepository.getLanguage(id);
        LanguageResource languageResource = new LanguageResource(language.getId(), language.getName(), language.getCode());
        return languageResource;

    }

    @Override
    public LanguageResource create(LanguageResource languageResource) {
        Language language = new Language(languageResource.getId(), languageResource.getName(), languageResource.getCode());
        language = languageRepository.createLanguage(language);
        languageResource.setId(language.getId());
        return languageResource;
    }

    private void test(){

        List<String> names=new ArrayList<>();
        names.add("Sudhir");
        names.add("Sudhir");
        names.add("Sudhir");
        names.add("Romi");
        names.add("Romi");
        names.add("Rajan");

        names.stream().collect(Collectors.toMap(k->k,v->1,Integer::sum));

        names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.summarizingInt(v->1)));





    }
}
