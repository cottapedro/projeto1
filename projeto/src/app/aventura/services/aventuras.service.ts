import { Injectable } from '@angular/core';
import { Http, RequestOptions } from '@angular/http';
//import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

const url = 'api/aventura';

@Injectable()
export class AventuraService {

  constructor(private http: Http) { }

//   findItensByEstrutura(id: number):Observable<ItemChecklist[]>{
//     return this.http.get(`${url}/qry/itens-estrutura/${id}`).map(res => res.json());
//   }

//   salvarItens(ItemChecklists: ItemChecklist[]): Observable<ItemChecklist[]>{
//     return  this.http.post(`${url}`,JSON.stringify(ItemChecklists)).map(res=>res.json());
//   }

//   removerItens(itemChecklistlista: ItemChecklist[]): Observable<any> {
//     return this.http.delete(`${url}`, new RequestOptions({ body: JSON.stringify(itemChecklistlista) }));
//   }
}