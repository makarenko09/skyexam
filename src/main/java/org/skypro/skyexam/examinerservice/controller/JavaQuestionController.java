package org.skypro.skyexam.examinerservice.controller;

import org.skypro.skyexam.examinerservice.service.QuestionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private QuestionService questionService;
    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    //FIXME
    //      Методы контроллера:
    // Добавить вопрос:
    // /exam/java/add?question=QuestionText&answer=QuestionAnswer
    // Удалить вопрос:
    // /exam/java/remove?question=QuestionText&answer=QuestionAnswer
    // Получить все вопросы:
    // /exam/java

}
