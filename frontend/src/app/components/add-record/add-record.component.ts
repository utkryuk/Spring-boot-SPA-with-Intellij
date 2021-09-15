import { Component, OnInit } from '@angular/core';
import { CrudServiceService } from 'src/app/crud-service.service';
import { Router, ActivatedRoute } from '@angular/router'; 
import { Phonebook } from 'src/app/phonebook';

@Component({
  selector: 'app-add-record',
  templateUrl: './add-record.component.html',
  styleUrls: ['./add-record.component.css']
})
export class AddRecordComponent implements OnInit {

  isAddMode?: boolean
  id: String

  record: Phonebook = {
    firstName: "",
    lastName: "",
    phone: 0
  }
  constructor(
    public crudService: CrudServiceService, 
    public route: ActivatedRoute,
    public router: Router
    ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']
    this.isAddMode = !this.id

    if (!this.isAddMode) {
      this.record = {
        firstName: history.state.firstName,
        lastName: history.state.lastName,
        phone: history.state.phone
      }

    }
  }

  createRecord() {
    this.crudService.create(this.record).subscribe((data: Phonebook) => {
      this.router.navigateByUrl("/home")
    })
  }

  updateRecord() {
    this.crudService.updateById(this.id, this.record).subscribe((data: Phonebook) => {
      this.router.navigateByUrl("/home", { state: this.record })
    })    
  }

  onSubmit(event: Event) {
    event.preventDefault()

    if (this.isAddMode) {
      this.createRecord()
    }
    else {
      this.updateRecord()
    }
  
  }

}
