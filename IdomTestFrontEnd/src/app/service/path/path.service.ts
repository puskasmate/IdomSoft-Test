import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Path } from 'src/app/model/path/path';

@Injectable({
  providedIn: 'root'
})
export class PathService {

  private baseURL = "http://localhost:8080/api/paths"

  constructor(private httpClient: HttpClient) { }
  getPathsToItinerary(itineraryId: number): Observable<Path[]> {
    return this.httpClient.get<Path[]>(`${this.baseURL}/getAllPathsToItinerary/`+itineraryId);
  }

  createPath(path: Path): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}/savePath`, path);
  }

  deletePathById(pathId: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/deletePathById/`+pathId, {responseType: 'text' as 'json'});
  }

}
