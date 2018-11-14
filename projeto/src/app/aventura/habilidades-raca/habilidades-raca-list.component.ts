import { Component, OnInit } from '@angular/core';
import { AventuraService } from '../services/aventuras.service';
import { Rpg } from '../services/rpg';
import { HabilidadesRaca } from '../services/habilidadeRaca';


@Component({
  selector: 'app-habilidades-raca-list',
  template: `
  <div class="casca">
    <h2>Componente do List de Habilidades de Raça</h2>
    <p>minhas habilidades de raça cadastradas:</p>
    <table class="table">
      <thead>
        <tr>
          <th>ID</th>
          <th>nome</th>
          <td>descrição</td>
          <th>tipo</th>
          <th>valor</th>
          <th>skill</th>
          <th>raça</th>
          <th>opções</th>
        </tr>
      </thead>
      <tbody>
        <tr *ngFor="let rpg of lstHabilidadesRaca">
          <td>{{rpg.id}}</td>
          <td>{{rpg.nome}}</td>
          <td>{{rpg.descricao}}</td>
          <td>{{rpg.tipoHabilidade}}</td>
          <td>{{rpg.valor}}</td>
          <td>{{rpg.skill}}</td>
          <td>{{rpg.raca.nome}}</td>
          <td>
            <button class="button" (click)="editarRpg(rpg.id)">
              <i class="fas fa-edit"></i>
            </button>
            <button class="button" (click)="removerRpg(rpg.id)">
              <i class="fas fa-trash"></i>
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  `
})
export class HabilidadesRacaListComponent implements OnInit {

  lstHabilidadesRaca: HabilidadesRaca[];
  constructor(
    private aventuraService: AventuraService
  ) {
  }

  ngOnInit() {
    this.aventuraService.findAllHabilidadesRaca().subscribe(e=>{
      this.lstHabilidadesRaca = e;
    })
  }

  editarRpg(id:number){

  }

  removerRpg(id:number){
    //this.aventuraService.removerUsuario(id).subscribe(e=>{});
  }
}