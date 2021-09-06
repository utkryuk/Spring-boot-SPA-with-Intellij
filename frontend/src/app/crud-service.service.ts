import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { Phonebook } from './phonebook';

@Injectable({
  providedIn: 'root'
})
export class CrudServiceService {

  private apiServer = "http://localhost:8081/api/phonebook"
  httpOptions = {
    headers: new Headers({
      'Content-Type': 'application/json'
    })
  }
  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Phonebook[]> {
    console.log(this.httpClient.get<Phonebook[]>(this.apiServer))
    return this.httpClient.get<Phonebook[]>(this.apiServer);
      // .pipe(
      //   catchError(this.errorHandler)
      // )
  }

  // errorHandler(error) {
    
  //   console.log(error);
  // }
}
