import { Component, OnInit } from '@angular/core';
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-survey',
  templateUrl: './survey.component.html',
  styleUrls: ['./survey.component.css']
})
export class SurveyComponent implements OnInit {
  //
  // constructor() { }
  //
  // ngOnInit(): void {
  // }

  // constructor() { }

  ngOnInit(): void {
  }

  title = 'Register for stuff';
  formGroup;

  constructor(
    private formBuilder: FormBuilder
  ) {
    this.formGroup = this.formBuilder.group({
      name: '',
      email: '',
      terms: false
    });
  }

  onSubmit(formData) {
    console.log(formData)
    var name = formData['name'];
  }
}
