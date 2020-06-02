package com.fincovi.assessment.utils;

import com.fincovi.assessment.resource.ResponseResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * assessment
 *
 * @author <<sudhir dubey>>
 * @copyright Copyright (c) 2020 - fincovi - All Rights Reserved
 * @since may 22, 2020
 */
public interface ResponseBuilder {
    static ResponseEntity<ResponseResource> build(Object data, HttpStatus httpStatus) {
        ResponseResource responseResource = new ResponseResource();

        responseResource.setData(data);
        responseResource.setResult(ResponseResource.ResultType.SUCCESS);
        ResponseEntity<ResponseResource> responseEntity = new ResponseEntity(responseResource, httpStatus);
        return responseEntity;
    }
}
