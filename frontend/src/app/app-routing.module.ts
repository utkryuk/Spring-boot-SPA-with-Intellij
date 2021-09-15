import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddRecordComponent } from './components/add-record/add-record.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { RecordsComponent } from './components/records/records.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },  
  { path: 'home' , component: RecordsComponent },
  { path: 'addRecord' , component: AddRecordComponent },
  { path: 'editRecord/:id', component: AddRecordComponent },
  { path: '404', component: NotFoundComponent },
  { path: '**', redirectTo: '/404' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
