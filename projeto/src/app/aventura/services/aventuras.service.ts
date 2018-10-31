import { Injectable } from '@angular/core';
import { Rpg } from './rpg';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch'
import { Observable } from "rxjs/Rx";
import { Raca } from './raca';

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
                         .subscribe();
  }

  findAllRpgs():Observable<Rpg[]>{
    return this.http.get(`${url}/rpg`).map(res => res.json());
  }

  findAllRacas():Observable<Raca[]>{
    return this.http.get(`${url}/raca`).map(res => res.json());
  }

  salvarRaca(raca:Raca){
    let bodyString = JSON.stringify(raca);
        let headers      = new Headers({ 'Content-Type': 'application/json' });
        let options       = new RequestOptions({ headers: headers });

        return this.http.post(`${url}/raca`, bodyString, options)
                         .map(res => res.json())
                         .catch((error:any) => Observable.throw(error.json().error || 'Server error'))
                         .subscribe();
  }

}