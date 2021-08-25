import { Component, OnInit } from '@angular/core';
import { AventuraService } from '../services/aventuras.service';
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
          <th>raça</th>
          <th>opções</th>
        </tr>
      </thead>
      <tbody>
        <tr *ngFor="let habilidadesRaca of lstHabilidadesRaca">
          <td>{{habilidadesRaca.id}}</td>
          <td>{{habilidadesRaca.nome}}</td>
          <td>{{habilidadesRaca.raca.nome}}</td>
          <td>
            <button class="button" (click)="editarHabilidadesRaca(habilidadesRaca.id)">
              <i class="fas fa-edit"></i>
            </button>
            <button class="button" (click)="removerHabilidadesRaca(habilidadesRaca.id)">
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
      console.log(e);
      this.lstHabilidadesRaca = e;
    })
  }

  editarHabilidadesRaca(id:number){

  }

  removerHabilidadesRaca(id:number){
    this.aventuraService.removerHabilidadeRaca(id).subscribe(e=>{});
  }
}