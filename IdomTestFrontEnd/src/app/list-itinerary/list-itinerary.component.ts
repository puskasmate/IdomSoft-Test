import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Itinerary } from '../model/itinerary/itinerary';
import { Path } from '../model/path/path';
import { ItineraryService } from '../service/itinerary/itinerary.service';

@Component({
  selector: 'app-list-itinerary',
  templateUrl: './list-itinerary.component.html',
  styleUrls: ['./list-itinerary.component.css']
})
export class ListItineraryComponent implements OnInit {

  itineraries!: Itinerary[];
  carId!: number;

  constructor(private itineraryService: ItineraryService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    
    this.fetchItineraries();
    
  }

  fetchItineraries() {
    let carId =  parseInt(this.activatedRoute.snapshot.paramMap.get('carId')!);
    this.carId = carId;
    this.itineraryService.getItinerariesToCar(carId).subscribe(
      data => {
                console.log("Data succesfully recieved.");
                this.itineraries=data;
      },
      error => {
        console.log(error);
      }
    );
  }

  getPathsToItinerary(itineraryId : number) {
    this.router.navigate(["getPaths", itineraryId]);
  }

  createItinerary() {
    this.router.navigate(["createItinerary", this.carId]);
  }

  deleteItinerary(itineraryId: number) {
    if (confirm('Biztosan törli a kiválasztott menetlevelet?')) {
      this.itineraryService.deleteItineraryById(itineraryId).toPromise();
      this.itineraries = this.itineraries.filter(itinerary => itinerary.id != itineraryId);
    } else {
      this.fetchItineraries();
      this.router.navigate(["getItineraries", this.carId]);
    }
  }

}
