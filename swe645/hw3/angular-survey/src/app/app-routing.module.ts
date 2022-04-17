import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AllSurveysComponent} from "./all-surveys/all-surveys.component";
import {HomeComponent} from "./home/home.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'allSurveys', component: AllSurveysComponent}]
// const routes: Routes = [{path: '/all-surveys', component: AllSurveysComponent},
//   {path: 'products/:productId', component: ProductDetailsComponent},];

@NgModule({
  imports: [RouterModule.forRoot(routes),


  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}