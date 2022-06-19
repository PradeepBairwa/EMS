import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './Components/login/login.component';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { FormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import{HttpClientModule}from'@angular/common/http';
import { DashboardComponent } from './Components/dashboard/dashboard.component';
import { SidebarComponent } from './Components/sidebar/sidebar.component';
import {MatListModule} from '@angular/material/list';
import {MatIconModule} from '@angular/material/icon';
import { AddEmployeeComponent } from './Components/add-employee/add-employee.component';
import { AllEmployeeComponent } from './Components/all-employee/all-employee.component';
import { authInterceptorProviders } from './services/auth.interceptor';
import { UpdateEmployeeComponent } from './Components/update-employee/update-employee.component';
import { NavbarComponent } from './Components/navbar/navbar.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import { SearchEmployeeComponent } from './Components/search-employee/search-employee.component';
import {MatSelectModule} from '@angular/material/select';

import { Ng2SearchPipeModule } from 'ng2-search-filter';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    SidebarComponent,
    AddEmployeeComponent,
    AllEmployeeComponent,
    UpdateEmployeeComponent,
    NavbarComponent,
    SearchEmployeeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    MatCardModule,
    MatFormFieldModule,
    MatSnackBarModule,
    FormsModule,
    MatInputModule,
    MatButtonModule,
    HttpClientModule,
    MatListModule,
    MatIconModule,
    MatToolbarModule,
    MatSelectModule,
    Ng2SearchPipeModule
    
    
    
    
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
