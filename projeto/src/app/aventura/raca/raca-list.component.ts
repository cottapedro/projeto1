import { Component, OnInit } from '@angular/core';
import { AventuraService } from '../services/aventuras.service';
import { Rpg } from '../services/rpg';
import { Raca } from '../services/raca';


@Component({
  selector: 'app-raca-list',
  template: `
  <div class="casca">
    <h2>Componente do List de Raças</h2>
    <p>minhas raças cadastrados:</p>
    <table class="table">
      <thead>
        <tr>
          <th>ID</th>
          <th>nome</th>
          <th>descrição</th>
          <th>rpg</th>
          <th>opcões</th>
        </tr>
      </thead>
      <tbody>
        <tr *ngFor="let raca of racas">
          <td>{{raca.id}}</td>
          <td>{{raca.nome}}</td>
          <td>{{raca.descricao}}</td>
          <td>{{raca.rpg.nome}}</td>
          <td>
            <button class="button" (click)="editarRaca(raca.id)">
              <i class="fas fa-edit"></i>
            </button>
            <button class="button" (click)="removerRaca(raca.id)">
              <i class="fas fa-trash"></i>
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  `
})
export class RacaListComponent implements OnInit {

  racas: Raca[];
  constructor(
    private aventuraService: AventuraService
  ) {
  }

  ngOnInit() {
    this.aventuraService.findAllRacas().subscribe(e=>{
      this.racas = e;
    })
  }

  editarRaca(id:number){

  }

  removerRaca(id:number){
    //this.aventuraService.removerUsuario(id).subscribe(e=>{});
  }
}