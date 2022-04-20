import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPathComponent } from './add-path/add-path.component';
import { CarListComponent } from './car-list/car-list.component';
import { CreateItineraryComponent } from './create-itinerary/create-itinerary.component';
import { ListItineraryComponent } from './list-itinerary/list-itinerary.component';
import { ListPathComponent } from './list-path/list-path.component';

const routes: Routes = [
  {path: 'cars', component: CarListComponent},
  {path: '', redirectTo: 'cars', pathMatch: 'full'},
  {path: 'getItineraries', component: ListItineraryComponent},
  {path:'getItineraries/:carId', component:ListItineraryComponent},
  {path: 'getPaths', component: ListPathComponent},
  {path:'getPaths/:itineraryId', component:ListPathComponent},
  {path: 'createItinerary', component: CreateItineraryComponent},
  {path: 'createItinerary/:carId', component: CreateItineraryComponent},
  {path: 'createPath', component: AddPathComponent},
  {path: 'createPath/:itineraryId', component: AddPathComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
