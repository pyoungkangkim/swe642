package com.example.demo.service;

import com.example.demo.repo.SurveyRepo;
import com.example.demo.repo.model.Survey;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {
    private final SurveyRepo surveyRepo;

    public SurveyService(SurveyRepo surveyRepo) {
        this.surveyRepo = surveyRepo;
    }

    public void saveSurvey(Survey survey) {
        this.surveyRepo.save(survey);
    }
}
