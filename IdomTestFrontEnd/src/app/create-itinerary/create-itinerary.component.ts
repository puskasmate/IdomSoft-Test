import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Itinerary } from '../model/itinerary/itinerary';
import { ItineraryService } from '../service/itinerary/itinerary.service';

@Component({
  selector: 'app-create-itinerary',
  templateUrl: './create-itinerary.component.html',
  styleUrls: ['./create-itinerary.component.css']
})
export class CreateItineraryComponent implements OnInit {

  itinerary: Itinerary = new Itinerary();

  constructor(private itineraryService: ItineraryService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.itinerary.car_id =  parseInt(this.activatedRoute.snapshot.paramMap.get('carId')!);
  }

  onSubmit() {
      console.log(this.itinerary);
      this.createItinerary();
  }

  createItinerary() {
    this.itineraryService.createItinerary(this.itinerary).subscribe( data => {
      console.log(data);
      this.goToItineraryList();
    }, error => {
      console.log(error);
    })
  }

  goToItineraryList() {
    let carId = this.itinerary.car_id;
    this.router.navigate([`/getItineraries/${carId}`]);
  }

  validateDateFormat(){
    const userKeyRegExp = /^[0-9]{4}\-[0-9]{2}\-[0-9]{2} [0-9]{2}\:[0-9]{2}\:[0-9]{2}?$/;

    if (userKeyRegExp.test(this.itinerary.startDate)) {
      return false;
    } else {
      return true;
    }

  }

}
