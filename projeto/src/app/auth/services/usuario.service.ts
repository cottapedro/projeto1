import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions } from '@angular/http';
import { Usuario } from 'src/app/auth/services/usuario';
//import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { Observable } from "rxjs/Rx";

const url = 'https://5b8ebe04eb676700148a4c82.mockapi.io';
//const url = 'api/usuario';
//http(s)://5b8ebe04eb676700148a4c82.mockapi.io/:endpoint
@Injectable()
export class UsuarioService {

  constructor(private http: Http) { }

  findUsuarioById(id: number):Observable<Usuario>{
    return this.http.get(`${url}/usuarios/${id}`).map(res => res.json());
  }

  findAllUsuarios():Observable<Usuario[]>{
    return this.http.get(`${url}/usuarios`).map(res => res.json());
  }

  removerUsuario(id: number): Observable<any> {
    return this.http.delete(`${url}/usuario/${id}`);
  }

//   salvarItens(anyItems: any[]): Observable<any[]>{
//     return  this.http.post(`${url}`,JSON.stringify(anyItems)).map(res=>res.json());
//   }

//   removerItens(anyItems: any[]): Observable<any> {
//     return this.http.delete(`${url}`, new RequestOptions({ body: JSON.stringify(anyItems) }));
//   }
}