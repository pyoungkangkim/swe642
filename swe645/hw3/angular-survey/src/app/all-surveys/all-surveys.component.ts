import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-all-surveys',
  templateUrl: './all-surveys.component.html',
  styleUrls: ['./all-surveys.component.css']
})
export class AllSurveysComponent implements OnInit {

  surveys = [];

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.http.get<any>('http://a47bf37c0a70f4a5eba390eea8c3675b-1557363398.us-east-1.elb.amazonaws.com/api/survey')
      .subscribe(response => response.forEach(data => this.surveys.push(data)))
    console.log(this.surveys)
  }

}
