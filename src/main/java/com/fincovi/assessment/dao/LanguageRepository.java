package com.fincovi.assessment.dao;

import com.fincovi.assessment.domain.Language;
import com.fincovi.assessment.exception.OperationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LanguageRepository extends JpaRepository<Language, String> {
    default Language getLanguage(String id) {

        Optional<Language> optionalLanguage = findById(id);
        optionalLanguage.orElseThrow(() -> new OperationException(String.format("Language with %s not found ", id),
                HttpStatus.NOT_FOUND));
        Language language = optionalLanguage.get();
        return language;
    }

    default Language createLanguage(Language language) {
        Language savedLanguage = null;
        try {
            savedLanguage = save(language);
        } catch (Exception e) {
            throw new OperationException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return savedLanguage;
    }
}
