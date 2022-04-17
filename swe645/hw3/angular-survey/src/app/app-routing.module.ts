import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AllSurveysComponent} from "./all-surveys/all-surveys.component";

const routes: Routes = [{path: 'allSurveys', component: AllSurveysComponent}]
// const routes: Routes = [{path: '/all-surveys', component: AllSurveysComponent},
//   {path: 'products/:productId', component: ProductDetailsComponent},];

@NgModule({
  imports: [RouterModule.forRoot(routes),


  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
