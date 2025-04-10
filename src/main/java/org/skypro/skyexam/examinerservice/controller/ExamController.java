package org.skypro.skyexam.examinerservice.controller;

import org.skypro.skyexam.examinerservice.domain.Question;
import org.skypro.skyexam.examinerservice.service.ExamError;
import org.skypro.skyexam.examinerservice.service.ExaminerService;
import org.skypro.skyexam.examinerservice.service.MoreQuestionsRequestedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @ExceptionHandler(MoreQuestionsRequestedException.class)
    public ResponseEntity<ExamError> handleMoreQuestionsRequestedException(MoreQuestionsRequestedException e) {
        String code = "BAD_REQUEST";
        String message = String.format("%s %s", LocalDateTime.now(), e.getMessage());
        ExamError examError = new ExamError(code, message);
        return new ResponseEntity<ExamError>(examError, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }

}
