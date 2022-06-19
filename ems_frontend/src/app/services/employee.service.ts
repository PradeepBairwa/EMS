import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  public loginStatusSubject = new Subject<boolean>();

  constructor(private http:HttpClient) { }


  // public employees(token:any){
  //   let tokenStr='Bearer '+token;
  //   const headers=new HttpHeaders().set("Authorization",tokenStr);
  //   return this.http.get(`${baseUrl}/emp/all`,{headers,responseType:'text' as 'json'});
  // }
  public employees(){
    return this.http.get(`${baseUrl}/emp/all`);
  }



  public addEmp(employee:any){
    return this.http.post(`${baseUrl}/emp/add`,employee)
  }

  public deleteEmp(id:any){
    return this.http.delete(`${baseUrl}/emp/delete/${id}`)
  }

  public getById(id:any){
    return this.http.get(`${baseUrl}/emp/id/${id}`)
  }

  public updateEmp(employee:any){
    return this.http.put(`${baseUrl}/emp/update`,employee)

  }
  public searchByName(name:any){
    return this.http.get(`${baseUrl}/emp/name/${name}`)
  }
  public searchByDob(dob:any){
    return this.http.get(`${baseUrl}/emp/dob/${dob}`)
  }
}
