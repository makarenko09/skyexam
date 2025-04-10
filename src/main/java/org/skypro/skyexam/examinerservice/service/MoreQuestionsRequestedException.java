package org.skypro.skyexam.examinerservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MoreQuestionsRequestedException extends RuntimeException {
    private String message;
    public MoreQuestionsRequestedException(String message) {
        super(message);
    }
}
