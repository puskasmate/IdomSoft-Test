import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Car } from '../model/car/car';
import { CarService } from '../service/car/car.service';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {

  cars!: Car[];

  constructor(private carService: CarService, private _router: Router) { }

  ngOnInit(): void {
    this.getCars();
  }

  private getCars() {
    this.carService.getCarList().subscribe(data => {
      this.cars = data;
    }, error => {
      console.log(error);
    });
  }

  getItineraries(carId : number) {
    this._router.navigate(["getItineraries", carId]);
  }

}
