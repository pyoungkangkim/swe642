// The routes are set up here for navigating components
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AllSurveysComponent} from "./all-surveys/all-surveys.component";
import {HomeComponent} from "./home/home.component";
import {SurveyComponent} from "./survey/survey.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'survey', component: SurveyComponent},
  {path: 'allSurveys', component: AllSurveysComponent}
  ]

@NgModule({
  imports: [RouterModule.forRoot(routes),
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
