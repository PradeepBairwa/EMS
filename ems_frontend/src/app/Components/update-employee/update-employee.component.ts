import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from 'src/app/services/employee.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  empId:any;
  employee:any= {
    "employeeId": '',
    "employeeName": "",
    "salary": '',
    "contactNo": "",
    "gender": "",
    "dob": ""
}
errorMsg:any="Pradeep";
  constructor(private route:ActivatedRoute,
    private emp:EmployeeService,
    private router:Router,
    
    ) { }

  ngOnInit(): void {
    this.empId=this.route.snapshot.params['employeeId'];

    this.emp.getById(this.empId).subscribe(
      (data:any)=>{
        this.employee=data;
        console.log("data :"+data)
      },(error)=>{
      
        Swal.fire("Error","Server Error ","error");
        console.log(error);
        console.log("Error in Search By Id ");
      }
    )
  }
  updateEmp(){
   this.emp.updateEmp(this.employee).subscribe(
    (data)=>{
      data=this.employee;
      console.log("Upadted .. data"+data);
      Swal.fire("Success","Updated","success");
      this.reset();
    },(error:any)=>{
      if (error instanceof HttpErrorResponse) {
        Swal.fire("Error",error.error.errorMessage,"error");

      }
      console.log(error);
    }
   )

  }
 

  reset(){
       this. employee= {
        "employeeId": '',
        "employeeName": "",
        "salary": '',
        "contactNo": "",
        "gender": "",
        "dob": ""
    }
  }

}
