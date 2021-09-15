import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

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
    return this.httpClient.get<Phonebook[]>(this.apiServer);
  }

  getById(id: String): Observable<Phonebook> {
    return this.httpClient.get<Phonebook>(`${this.apiServer}/${id}`);
  }

  create(record: Phonebook): Observable<Phonebook> {
    return this.httpClient.post<Phonebook>(this.apiServer, record);
  } 

  updateById(id: String, record: Phonebook): Observable<Phonebook> {
    return this.httpClient.put<Phonebook>(`${this.apiServer}/${id}`, record);
  }

  deleteById(id: String): Observable<any> {
    return this.httpClient.delete<any>(`${this.apiServer}/${id}`);
  }

}
