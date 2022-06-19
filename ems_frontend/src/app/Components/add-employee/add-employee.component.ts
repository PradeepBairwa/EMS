import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/services/employee.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  employee= {
    
    "employeeName": "",
    "salary": '',
    "contactNo": "",
    "gender": "",
    "dob": ""
}
  constructor(private emp:EmployeeService) { }

  ngOnInit(): void {
  }

  addEmp(){

    console.log("Employee "+this.employee);
    this.emp.addEmp(this.employee).subscribe(
      (data)=>{

        Swal.fire("Success",'Employee is Added successfuly','success');
        console.log("Employee Added");
      },(error)=>{
        if (error instanceof HttpErrorResponse) {
          Swal.fire("Error",error.error.errorMessage,"error");
  
        }
        console.log("Something is wrong");
      }
    )
  }

  reset(){
   this. employee= {
      
      "employeeName": '',
      "salary": '',
      "contactNo": '',
      "gender": '',
      "dob": ''
  }
  }

}
