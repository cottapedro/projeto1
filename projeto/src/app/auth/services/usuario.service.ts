import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Usuario } from 'src/app/auth/services/usuario';
import { Login } from 'src/app/auth/services/login';
//import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch'
import { Observable } from "rxjs/Rx";


const url = 'http://localhost:8080';
//const url = 'api/usuario';
//http(s)://5b8ebe04eb676700148a4c82.mockapi.io/:endpoint
@Injectable()
export class UsuarioService {

  constructor(private http: Http) { }

  login(login:Login){
    console.log('no service', login);
    let bodyString = JSON.stringify(login);
        let headers      = new Headers({ 'Content-Type': 'application/json' });
        let options      = new RequestOptions({ headers: headers });

        return this.http.post(`${url}/login`, bodyString, options)
                         .map(res => res.json())
                         .catch((error:any) => Observable.throw(error.json().error || 'Server error'))
                         .subscribe();
  }

  findUsuarioById(id: number):Observable<Usuario>{
    return this.http.get(`${url}/usuarios/${id}`).map(res => res.json());
  }

  findAllUsuarios():Observable<Usuario[]>{
    return this.http.get(`${url}/usuario`).map(res => res.json());
  }

  removerUsuario(id: number): Observable<any> {
    return this.http.delete(`${url}/usuario/${id}`);
  }

  salvarItens(){
    let anyItems = {'nome': 'joao', 'email': 'teste'};
    console.log('dado que quero postar', JSON.stringify(anyItems));

    let bodyString = JSON.stringify(anyItems); // Stringify payload
        let headers      = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
        let options       = new RequestOptions({ headers: headers }); // Create a request option

        return this.http.post(`${url}/usuario`, bodyString, options) // ...using post request
                         .map(res => res.json()) // ...and calling .json() on the response to return data
                         .catch((error:any) => Observable.throw(error.json().error || 'Server error')) //...errors if
                         .subscribe();

    //return this.http.post(`${url}/usuario`,anyItems).map(res => res.json()).subscribe();
    //return this.http.post(`${url}/usuario`, null);
  }

  salvarUsuario(usuario:Usuario){
    let bodyString = JSON.stringify(usuario); // Stringify payload
        let headers      = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
        let options       = new RequestOptions({ headers: headers }); // Create a request option

        return this.http.post(`${url}/usuario`, bodyString, options) // ...using post request
                         .map(res => res.json()) // ...and calling .json() on the response to return data
                         .catch((error:any) => Observable.throw(error.json().error || 'Server error')) //...errors if
                         .subscribe();
  }

//   removerItens(anyItems: any[]): Observable<any> {
//     return this.http.delete(`${url}`, new RequestOptions({ body: JSON.stringify(anyItems) }));
//   }
}