//the service class which handles the request by saving things to the database or retrieving it using surveyRepo
package com.example.demo.service;

import com.example.demo.repo.SurveyRepo;
import com.example.demo.repo.model.Survey;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {
    private final SurveyRepo surveyRepo;

    public SurveyService(SurveyRepo surveyRepo) {
        this.surveyRepo = surveyRepo;
    }

    public void saveSurvey(Survey survey) {
        this.surveyRepo.save(survey);
    }

    public List<Survey> getAllSurveys() {
        return (List<Survey>) this.surveyRepo.findAll();
    }
}
