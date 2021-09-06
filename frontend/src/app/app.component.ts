import { Component, OnInit } from '@angular/core';
import { CrudServiceService } from './crud-service.service';

import { Phonebook} from './phonebook';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  
  records: Phonebook[] = [];

  constructor(public crudService: CrudServiceService) {

  }

  // ngOnInit() {
  //   this.crudService
  //     .getAll().subscribe((data: Phonebook []) => {
  //       console.log(data);
  //       this.records = data;
  //   })
  // }

  ngOnInit() {
    this.crudService.getAll().subscribe((data: Phonebook[]) => {
      console.log(data);
      this.records = data;
    })
  }
}
