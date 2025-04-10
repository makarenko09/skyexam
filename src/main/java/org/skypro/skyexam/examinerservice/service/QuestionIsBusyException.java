package org.skypro.skyexam.examinerservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class QuestionIsBusyException extends RuntimeException {
    private String message;

    public QuestionIsBusyException(String message) {
        super(message);
    }
}
