import {Component, OnInit} from '@angular/core';
import {FormBuilder} from "@angular/forms";

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

  constructor(private formBuilder: FormBuilder) {
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
  }
}
