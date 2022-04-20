import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CarListComponent } from './car-list/car-list.component';
import { ListItineraryComponent } from './list-itinerary/list-itinerary.component';
import { ListPathComponent } from './list-path/list-path.component';
import { CreateItineraryComponent } from './create-itinerary/create-itinerary.component';
import { AddPathComponent } from './add-path/add-path.component';

@NgModule({
  declarations: [
    AppComponent,
    CarListComponent,
    ListItineraryComponent,
    ListPathComponent,
    CreateItineraryComponent,
    AddPathComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
