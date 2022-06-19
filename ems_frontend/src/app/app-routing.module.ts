import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './Components/add-employee/add-employee.component';
import { AllEmployeeComponent } from './Components/all-employee/all-employee.component';
import { DashboardComponent } from './Components/dashboard/dashboard.component';
import { LoginComponent } from './Components/login/login.component';
import { SearchEmployeeComponent } from './Components/search-employee/search-employee.component';
import { UpdateEmployeeComponent } from './Components/update-employee/update-employee.component';

const routes: Routes = [

  {
    path:'login',
    component:LoginComponent,
    pathMatch:'full'
  },
  {
    path:'emp',
    component:DashboardComponent,
    children:[
      {
 
        path:'add',
        component:AddEmployeeComponent
    },{
      path:'all-employee',
      component:AllEmployeeComponent
    },
    {
      path:'update-employee/:employeeId',
      component:UpdateEmployeeComponent
    },
    {
      path:'search-employee',
      component:SearchEmployeeComponent
    }
  
  ],
    

  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
