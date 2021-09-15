import { Component, OnInit } from '@angular/core';
import { CrudServiceService } from 'src/app/crud-service.service';
import { Phonebook } from 'src/app/phonebook';

@Component({
  selector: 'app-add-record',
  templateUrl: './add-record.component.html',
  styleUrls: ['./add-record.component.css']
})
export class AddRecordComponent implements OnInit {

  record: Phonebook = {
    firstName: "",
    lastName: "",
    phone: 0
  }
  constructor(public crudService: CrudServiceService) { }

  ngOnInit(): void {
  }

  createRecord(record: Phonebook) {
    this.crudService.create(record).subscribe((data: Phonebook) => {
      console.log(data);
    })
  }

  onSubmit(event: Event) {
    event.preventDefault()
    console.log(event)
    console.log(this.record)
    this.createRecord(this.record);
  }

}
