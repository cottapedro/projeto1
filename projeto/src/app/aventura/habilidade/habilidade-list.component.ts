import { Component, OnInit } from '@angular/core';
import { AventuraService } from '../services/aventuras.service';
import { Habilidade } from '../services/habilidade';


@Component({
  selector: 'app-habilidade-list',
  template: `
  <div class="casca">
    <h2>Componente do List de Habilidades</h2>
    <p>minhas habilidades cadastradas:</p>
    <table class="table">
      <thead>
        <tr>
          <th>ID</th>
          <td>descrição</td>
          <th>tipo</th>
          <th>valor</th>
          <th>skill</th>
          <th>opções</th>
        </tr>
      </thead>
      <tbody>
        <tr *ngFor="let habilidade of habilidades">
          <td>{{habilidade.id}}</td>
          <td>{{habilidade.descricao}}</td>
          <td>{{habilidade.tipoHabilidade}}</td>
          <td>{{habilidade.valor}}</td>
          <td>{{habilidade.skill}}</td>
          <td>
            <button class="button" (click)="editarHabilidade(habilidade.id)">
              <i class="fas fa-edit"></i>
            </button>
            <button class="button" (click)="removerHabilidade(habilidade.id)">
              <i class="fas fa-trash"></i>
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  `
})
export class HabilidadeListComponent implements OnInit {

  habilidades: Habilidade[];
  constructor(
    private aventuraService: AventuraService
  ) {
  }

  ngOnInit() {
    this.aventuraService.findAllHabilidade().subscribe(e=>{
      console.log(e);
      this.habilidades = e;
    })
  }

  editarHabilidade(id:number){

  }

  removerHabilidade(id:number){
    this.aventuraService.removerHabilidade(id).subscribe(e=>{});
  }
}