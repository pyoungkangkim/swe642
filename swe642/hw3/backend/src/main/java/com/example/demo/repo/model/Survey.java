//The Entity for JPA, which maps to the Table 'survey' and acts as the ORM
package com.example.demo.repo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="survey")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Survey {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "date")
    private String date;

    @Column(name = "student")
    private boolean student;

    @Column(name = "atmosphere")
    private boolean atmosphere;

    @Column(name = "location")
    private boolean location;

    @Column(name = "dorm")
    private boolean dorm;

    @Column(name = "campus")
    private boolean campus;

    @Column(name = "sport")
    private String sport;

    @Column(name = "interestedreason")
    private String interestedreason;

    @Column(name = "recommend")
    private String recommend;

    @Column(name = "comment")
    private String comment;
}
