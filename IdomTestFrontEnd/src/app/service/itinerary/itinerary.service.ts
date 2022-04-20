import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Itinerary } from 'src/app/model/itinerary/itinerary';
import { Path } from 'src/app/model/path/path';

@Injectable({
  providedIn: 'root'
})
export class ItineraryService {

  private baseURL = "http://localhost:8080/api/itineraries";

  constructor(private httpClient: HttpClient) { }

  getItinerariesToCar(carId: number): Observable<Itinerary[]> {
    return this.httpClient.get<Itinerary[]>(`${this.baseURL}/getAllItinerariesToCar/`+carId);
  }

  createItinerary(itinerary: Itinerary): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}/saveItinerary`, itinerary)
  }

  deleteItineraryById(itineraryId: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/deleteItinerary/${itineraryId}`, {responseType: 'text' as 'json'});
  }

}
