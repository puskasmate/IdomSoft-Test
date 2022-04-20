import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Path } from '../model/path/path';
import { PathService } from '../service/path/path.service';

@Component({
  selector: 'app-list-path',
  templateUrl: './list-path.component.html',
  styleUrls: ['./list-path.component.css']
})
export class ListPathComponent implements OnInit {

  paths!: Path[];
  itineraryId!: number;

  constructor(private pathService: PathService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {

    this.fetchPaths();

  }

  fetchPaths() {
    let itineraryId =  parseInt(this.activatedRoute.snapshot.paramMap.get('itineraryId')!);
    this.itineraryId = itineraryId;
    this.pathService.getPathsToItinerary(itineraryId).subscribe(
      data => {
                console.log("Data succesfully recieved.");
                this.paths=data;
      },
      error => {
        console.log(error);
      }
    );
  }

  createPath() {
    this.router.navigate(["createPath", this.itineraryId]);
  }

  deletePath(pathId: number) {
    if (confirm('Biztosan törli a kiválasztott útvonalat?')) {
      this.pathService.deletePathById(pathId).toPromise();
      this.paths = this.paths.filter(path => path.id != pathId);
    } else {
      this.fetchPaths();
      this.router.navigate(["getPaths", this.itineraryId]);
    }
  }

}
