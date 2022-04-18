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
      interest: '',
      // radio
      interestedreason: '',
      // select
      recommend: ''
    });
  }

  onSubmit(formData) {
    console.log(formData)
    var name = formData['name'];
    // this.http.post<any>('https://reqres.in/api/posts', { title: 'Angular POST Request Example' })
    //   .subscribe(data => console.log(data))
    this.http.get<any>('http://localhost:8000').subscribe(data => console.log(data))
  }
}
