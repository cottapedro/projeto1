import { Injectable } from '@angular/core';
import { Rpg } from './rpg';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch'
import { Observable } from "rxjs/Rx";
import { Raca } from './raca';
import {Pericia} from './pericia';
import {ArmaduraEscudo} from './armaduraEscudo';
import { HabilidadesRaca } from './habilidadeRaca';

const url = 'http://localhost:8080';

@Injectable()
export class AventuraService {

  constructor(private http: Http) { }

  salvarRpg(item:Rpg){
    let bodyString = JSON.stringify(item);
        let headers      = new Headers({ 'Content-Type': 'application/json' });
        let options      = new RequestOptions({ headers: headers });

        return this.http.post(`${url}/rpg`, bodyString, options)
                         .map(res => res.json())
                         .catch((error:any) => Observable.throw(error.json().error || 'Server error'))
                         .subscribe(()=>{alert('rpg cadastrada com sucesso!')});
  }

  findRpgById(id: number):Observable<Rpg>{
    return this.http.get(`${url}/rpg/${id}`).map(res => res.json());
  }

  findAllRpgs():Observable<Rpg[]>{
    return this.http.get(`${url}/rpg`).map(res => res.json());
  }

  removerRpg(id: number){
    let bodyString = JSON.stringify(id);
        let headers      = new Headers({ 'Content-Type': 'application/json' });

    return this.http.delete(`${url}/rpg`, new RequestOptions({
      headers: headers,
      body: bodyString
   })).catch((error:any) => Observable.throw(error.json().error || 'Server error'))
    //return this.http.delete(`${url}/usuario`, { body: {'id':id} });
  }

  findAllRacas():Observable<Raca[]>{
    return this.http.get(`${url}/raca`).map(res => res.json());
  }

  removerRaca(id: number){
    let bodyString = JSON.stringify(id);
        let headers      = new Headers({ 'Content-Type': 'application/json' });

    return this.http.delete(`${url}/raca`, new RequestOptions({
      headers: headers,
      body: bodyString
   }));
    //return this.http.delete(`${url}/usuario`, { body: {'id':id} });
  }
  
  salvarRaca(raca:Raca){
    let bodyString = JSON.stringify(raca);
    let headers      = new Headers({ 'Content-Type': 'application/json' });
    let options       = new RequestOptions({ headers: headers });
    
    return this.http.post(`${url}/raca`, bodyString, options)
    .map(res => res.json())
    .catch((error:any) => Observable.throw(error.json().error || 'Server error'))
    .subscribe(()=>{alert('raça cadastrada com sucesso!')});
  }

  findAllHabilidadesRaca():Observable<HabilidadesRaca[]>{
    return this.http.get(`${url}/habilidade-raca`).map(res => res.json());
  }

  salvarHabilidadesRaca(habilidadeRaca:HabilidadesRaca){
    let bodyString = JSON.stringify(habilidadeRaca);
    let headers      = new Headers({ 'Content-Type': 'application/json' });
    let options       = new RequestOptions({ headers: headers });
    
    return this.http.post(`${url}/habilidade-raca`, bodyString, options)
    .map(res => res.json())
    .catch((error:any) => Observable.throw(error.json().error || 'Server error'))
    .subscribe(()=>{alert('habilidade de raça cadastrada com sucesso!')});
  }

  removerHabilidadeRaca(id: number){
    let bodyString = JSON.stringify(id);
        let headers      = new Headers({ 'Content-Type': 'application/json' });

    return this.http.delete(`${url}/habilidade-raca`, new RequestOptions({
      headers: headers,
      body: bodyString
   }));
    //return this.http.delete(`${url}/usuario`, { body: {'id':id} });
  }
  
  findAllPericias():Observable<Pericia[]>{
    return this.http.get(`${url}/pericia`).map(res => res.json());
  }

  findPericiaById(id: number):Observable<Pericia>{
    return this.http.get(`${url}/pericia/${id}`).map(res => res.json());
  }
  
  salvarPericia(pericia:Pericia){
    let bodyString = JSON.stringify(pericia);
        let headers      = new Headers({ 'Content-Type': 'application/json' });
        let options       = new RequestOptions({ headers: headers });

        return this.http.post(`${url}/pericia`, bodyString, options)
                         .map(res => res.json())
                         .catch((error:any) => Observable.throw(error.json().error || 'Server error'))
                         .subscribe(()=>{alert('pericia cadastrada com sucesso!')});
  }

  removerPericia(id: number){
    let bodyString = JSON.stringify(id);
        let headers      = new Headers({ 'Content-Type': 'application/json' });

    return this.http.delete(`${url}/pericia`, new RequestOptions({
      headers: headers,
      body: bodyString
   }));
    //return this.http.delete(`${url}/usuario`, { body: {'id':id} });
  }


findAllArmaduraEscudo():Observable<ArmaduraEscudo[]>{
  return this.http.get(`${url}/armadura-escudo`).map(res => res.json());
}

salvarArmaduraEscudo(armaduraEscudo:ArmaduraEscudo){
  let bodyString = JSON.stringify(armaduraEscudo);
      let headers      = new Headers({ 'Content-Type': 'application/json' });
      let options       = new RequestOptions({ headers: headers });

      return this.http.post(`${url}/armadura-escudo`, bodyString, options)
                       .map(res => res.json())
                       .catch((error:any) => Observable.throw(error.json().error || 'Server error'))
                       .subscribe(()=>{alert('armadura/escudo cadastrada com sucesso!')});
}

removerArmaduraEscudo(id: number){
  let bodyString = JSON.stringify(id);
      let headers      = new Headers({ 'Content-Type': 'application/json' });

  return this.http.delete(`${url}/armadura-escudo`, new RequestOptions({
    headers: headers,
    body: bodyString
 }));
  //return this.http.delete(`${url}/usuario`, { body: {'id':id} });
}

}