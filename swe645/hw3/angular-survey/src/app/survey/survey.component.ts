// the survey component
import {Component, OnInit} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-survey',
  templateUrl: './survey.component.html',
  styleUrls: ['./survey.component.css']
})
export class SurveyComponent implements OnInit {
  ngOnInit(): void {
  }

  title = '';
  formGroup;

  constructor(private formBuilder: FormBuilder, private http: HttpClient) {
    this.formGroup = this.formBuilder.group({
      firstname: '',
      lastname: '',
      street: '',
      city: '',
      state: '',
      zip: '',
      phone: '',
      email: '',
      date: '',
      // mostliked
      student: '',
      atmosphere: '',
      location: '',
      dorm: '',
      campus: '',
      sport: '',
      // radio
      interestedreason: '',
      // select
      recommend: ''
    });
  }

  onSubmit(formData) {
    let body = JSON.stringify(formData);
    const options = {headers: {'Content-Type': 'application/json'}};
    console.log(body)
    // this.http.post<any>('http://localhost:8080/api/survey', body, options)
    this.http.post<any>('http://a47bf37c0a70f4a5eba390eea8c3675b-1557363398.us-east-1.elb.amazonaws.com/api/survey', body, options)
      .subscribe(data => console.log(data))
    // this.http.get<any>('http://localhost:8080/api/survey').subscribe(data => console.log(data))
  }
}
