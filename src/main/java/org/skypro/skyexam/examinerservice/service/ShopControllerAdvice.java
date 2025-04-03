package org.skypro.skyexam.examinerservice.service;


import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice(assignableTypes = ExaminerServiceImpl.class)
public class ShopControllerAdvice extends RuntimeException {

    @ExceptionHandler(MoreQuestionsRequestedException.class)
    public ResponseEntity<ExamError> handleMoreQuestionsRequestedException(MoreQuestionsRequestedException e) {
        String code = "BAD_REQUEST";
        String message = String.format("%s %s", LocalDateTime.now(), e.getMessage());
        ExamError examError = new ExamError(code, message);
        return new ResponseEntity<ExamError>(examError, HttpStatusCode.valueOf(400));
    }
}
