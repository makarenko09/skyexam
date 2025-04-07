package org.skypro.skyexam.examinerservice.controller;

import org.skypro.skyexam.examinerservice.domain.Question;
import org.skypro.skyexam.examinerservice.service.JavaQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService questionService;

    public JavaQuestionController(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/")
    Collection<Question> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("/remove")
    @ResponseBody
    public Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question object = new Question(question, answer);
        return questionService.remove(object);
    }

    @GetMapping("/add")
    @ResponseBody
    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }
}
