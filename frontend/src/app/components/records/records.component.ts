import { Component, OnInit } from '@angular/core';
import { CrudServiceService } from '../../crud-service.service';
import { Phonebook } from '../../phonebook';

@Component({
  selector: 'app-records',
  templateUrl: './records.component.html',
  styleUrls: ['./records.component.css']
})
export class RecordsComponent implements OnInit {
  
  records: Phonebook[] = [];

  constructor(public crudService: CrudServiceService) { }

  ngOnInit(): void {
    this.crudService.getAll().subscribe((data: Phonebook[]) => {
      console.log(data);
      this.records = data;
    })
  }

  getByRecordId(id: String) {
    this.crudService.getById(id).subscribe((data: Phonebook) => {
      console.log(data);
    })
  }

  createRecord(record: Phonebook) {
    this.crudService.create(record).subscribe((data: Phonebook) => {
      console.log(data);
    })
  }

  updateRecord(id: String, record: Phonebook) {
    this.crudService.updateById(id, record).subscribe((data: Phonebook) => {
      console.log(data);
    })
  }

  deleteRecord(id: String) {
    this.crudService.deleteById(id).subscribe((data: any) => {
      console.log(data);
    })
  }

}
