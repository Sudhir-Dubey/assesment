package com.fincovi.assessment.service;

import com.fincovi.assessment.resource.LanguageResource;

public interface LanguageService {
    public LanguageResource get(String id);
    public LanguageResource create(LanguageResource languageResource);

}
