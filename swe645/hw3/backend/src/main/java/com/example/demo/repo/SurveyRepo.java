package com.example.demo.repo;

import com.example.demo.repo.model.Survey;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SurveyRepo extends CrudRepository<Survey, UUID> {
}
