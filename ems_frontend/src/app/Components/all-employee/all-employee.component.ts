import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/services/employee.service';
import { LoginService } from 'src/app/services/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-all-employee',
  templateUrl: './all-employee.component.html',
  styleUrls: ['./all-employee.component.css']
})
export class AllEmployeeComponent implements OnInit {

  employees:any=[
    {
      "employeeId": 551,
      "employeeName": "test Me",
      "salary": 100000,
      "contactNo": "1234567890",
      "gender": "Male",
      "dob": "03-06-2022"
    }
  ]
  newToken:any;
  searchText:any
  constructor(private employee:EmployeeService,private loginService:LoginService) { }

  
  ngOnInit(): void {

    this.newToken=this.loginService.getToken();
    console.log("Token.. "+this.newToken);
   

    this.employee.employees().subscribe(
      (data:any)=>{
          this.employees=data;
      },(error:any)=>{
        Swal.fire("Error","Server Error","error");
        console.log(error);
      }
    )
    

  }

  delete(id:any){
    this.employee.deleteEmp(id).subscribe(
      (data)=>{
        Swal.fire("Success",'Employee is Deleted successfuly','success');

      },(error)=>{
        Swal.fire("Error","Server Error","error");
        console.log(error);
      }
    )   
  }



}
