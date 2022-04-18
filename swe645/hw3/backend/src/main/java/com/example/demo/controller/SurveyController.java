package com.example.demo.controller;

import com.example.demo.repo.model.Survey;
import com.example.demo.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/survey")
@RequiredArgsConstructor
public class SurveyController {
    private final SurveyService surveyService;

    @GetMapping
    public String hi() {
        return "hi";
    }

    @PostMapping
    public ResponseEntity submitForm(@RequestBody Survey survey) {
        System.out.println(survey);
        surveyService.saveSurvey(survey);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
