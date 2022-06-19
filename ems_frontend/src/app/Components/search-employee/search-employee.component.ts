import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { isEmpty } from 'rxjs';
import { EmployeeService } from 'src/app/services/employee.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-search-employee',
  templateUrl: './search-employee.component.html',
  styleUrls: ['./search-employee.component.css']
})
export class SearchEmployeeComponent implements OnInit {

 selectedValue:any;
  type:any;
  employee:any=[
    {
      "employeeId": 551,
      "employeeName": "Dummy Data",
      "salary": 100000,
      "contactNo": "1234567890",
      "gender": "Male",
      "dob": "03-06-2022"
    },
    
  ]
    
  

  constructor(private emp:EmployeeService) { }

  ngOnInit(): void {
  }

  search(){
     if(this.selectedValue=='Id'){
       this.emp.getById(this.type).subscribe(
        (data:any)=>{
           this.employee=data;
           console.log(this.employee);
        },(error)=>{
          console.log(error);
          if (error instanceof HttpErrorResponse) {
            Swal.fire("Error",error.error.errorMessage,"error");
    
          }
        }
       )
     }else if(this.selectedValue=='Name'){
      this.emp.searchByName(this.type).subscribe(
        (data)=>{
          this.employee=data;
          console.log(data);
        },(error)=>{
          if (error instanceof HttpErrorResponse) {
            Swal.fire("Error",error.error.errorMessage,"error");
    
          }      
        }
      )
     }else if(this.selectedValue=='Dob'){
      this.emp.searchByDob(this.type).subscribe(
        (data)=>{
          this.employee=data;
          console.log(data);
          
        },(error)=>{
          if (error instanceof HttpErrorResponse) {
            Swal.fire("Error",error.error.errorMessage,"error");
    
          }
                    console.log(error);
        }
      )
     }
  }
  delete(id:any){
    this.emp.deleteEmp(id).subscribe(
      (data:any)=>{
        Swal.fire("Success",'Employee is Deleted successfuly','success');

      },(error:any)=>{
        if (error instanceof HttpErrorResponse) {
          Swal.fire("Error",error.error.errorMessage,"error");
  
        }
        console.log(error);
      }
    )   
  }
  reset(){
    this.selectedValue='';
    this.type='';
  }

}
