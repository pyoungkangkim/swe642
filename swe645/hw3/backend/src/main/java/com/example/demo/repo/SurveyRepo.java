//the repo class, which under the hood uses JPA(uses JDBC under the hood also) and hibernate to give you a CRUD functionality for DB
package com.example.demo.repo;

import com.example.demo.repo.model.Survey;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SurveyRepo extends CrudRepository<Survey, UUID> {
}
