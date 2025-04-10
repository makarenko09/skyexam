package org.skypro.skyexam.examinerservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoSuchQuestionException extends RuntimeException {
    private String message;
    public NoSuchQuestionException(String message) {
        super(message);
    }
}
