import { not } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Path } from '../model/path/path';
import { PathService } from '../service/path/path.service';

@Component({
  selector: 'app-add-path',
  templateUrl: './add-path.component.html',
  styleUrls: ['./add-path.component.css']
})
export class AddPathComponent implements OnInit {

  path: Path = new Path();

  constructor(private pathService: PathService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {

    this.path.itinerary_id =  parseInt(this.activatedRoute.snapshot.paramMap.get('itineraryId')!);
  }


  onSubmit() {
    this.createPath();
  }

  validateInputFormat(){
    const userKeyRegExp = /^[0-9]{4}\-[0-9]{2}\-[0-9]{2} [0-9]{2}\:[0-9]{2}\:[0-9]{2}?$/;

    if (userKeyRegExp.test(this.path.endDate) && this.path.driverName != '' &&
     this.path.fromWhere != '' && this.path.toWhere != '' && this.path.kilometreStance > 0 && this.path.numberOfTransportedPassengers > 0) {
      return false;
    } else {
      return true;
    }

  }

  createPath() {
    this.pathService.createPath(this.path).subscribe( data => {
      console.log(data);
      this.goToPaths();
    }, error => {
      console.log(error);
    });
  }

  goToPaths() {
    let itineraryId = this.path.itinerary_id;
    this.router.navigate([`/getPaths/${itineraryId}`])
  }

}
