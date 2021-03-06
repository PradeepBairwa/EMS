import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

// const TOKEN_HEADER='Authorization';
@Injectable()
export class AuthInterceptor implements HttpInterceptor
{
    constructor(private login:LoginService){} 

    intercept(
        req: HttpRequest<any>, 
        next: HttpHandler
        ): Observable<HttpEvent<any>> {
        //add the JWT token from localstorage request
        let authReq=req;
        const token=this.login.getToken();
        console.log('Inside Interceptor');
        console.log(token);

        if(token!=null){
            authReq=authReq.clone({
                // method:'post',
                setHeaders:{
                    
                    // 'Accept': 'application/json',
                    // 'Content-Type': 'application/json',
                    // mode: 'cors',
                    Authorization:`Bearer ${token}` },
                

            });

        }
        return next.handle(authReq);
    }
    
}

export const authInterceptorProviders=[
    {
        provide:HTTP_INTERCEPTORS,
        useClass:AuthInterceptor,
        multi:true,

    },
];