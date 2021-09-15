import { Component, OnInit } from '@angular/core';
import { CrudServiceService } from '../../crud-service.service';
import { Phonebook } from '../../phonebook';
import { Router } from '@angular/router';
@Component({
  selector: 'app-records',
  templateUrl: './records.component.html',
  styleUrls: ['./records.component.css']
})
export class RecordsComponent implements OnInit {
  
  records: Phonebook[] = [];

  constructor(
    public crudService: CrudServiceService, 
    public router: Router
    ) { }

  ngOnInit(): void {
    this.crudService.getAll().subscribe((data: Phonebook[]) => {
      // console.log(data);
      this.records = data;
    })
    
  }

  deleteRecord(record: Phonebook) {
    if (window.confirm("Are you sure you want to delete this record?")) {
      this.crudService.deleteById(record.id!).subscribe((data : any) => {
        let index: number = this.records.indexOf(record)
        if (index > -1) {
          this.records.splice(index, 1);
        }
      })
    }
  }

  updateRecord(record: Phonebook) {
    this.router.navigateByUrl(`/editRecord/${record.id}`, { state : record });
  }

}
