import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Car } from 'src/app/model/car/car';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private baseURL = "http://localhost:8080/api/cars";
  constructor(private httpClient: HttpClient) { }

  getCarList(): Observable<Car[]> {
    return this.httpClient.get<Car[]>(`${this.baseURL}/getAllCars`);
  }
}
