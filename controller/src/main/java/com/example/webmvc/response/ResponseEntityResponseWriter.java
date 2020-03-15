package com.example.webmvc.response;

import org.springframework.http.ResponseEntity;

import com.example.controller.response.ResponseWriter;

public class ResponseEntityResponseWriter implements ResponseWriter {

    private ResponseEntity<Object> responseEntity;

    @Override
    public void ok(Object resource) {
        responseEntity = ResponseEntity.ok(resource);
    }

    public ResponseEntity<Object> getResponseEntity() {
        return responseEntity;
    }
}
