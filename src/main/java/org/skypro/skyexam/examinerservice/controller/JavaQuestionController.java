package org.skypro.skyexam.examinerservice.controller;

import org.skypro.skyexam.examinerservice.domain.Question;
import org.skypro.skyexam.examinerservice.service.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private JavaQuestionService questionService;

    public JavaQuestionController(JavaQuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("/")
    Collection<Question> getQuestions() {
        return questionService.getQuestions();
    }
    @GetMapping("/remove/{question}&{answer}")
    public Question removeQuestion(@PathVariable ("question")String question,@PathVariable("answer") String answer) {
        return questionService.remove(question, answer);
    }
    @GetMapping("/add/{question}&{answer}")
public Question addQuestion(@PathVariable ("question")String question,@PathVariable("answer") String answer) {
return questionService.add(question,answer);
}
}
