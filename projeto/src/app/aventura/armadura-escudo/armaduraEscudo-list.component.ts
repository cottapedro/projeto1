import { Component, OnInit } from '@angular/core';
import { AventuraService } from '../services/aventuras.service';
import { ArmaduraEscudo } from '../services/armaduraEscudo';


@Component({
  selector: 'app-armaduraEscudo-list',
  template: `
  <div class="casca">
    <h2>Componente do List de Armaduras e Escudos</h2>
    <p>minhas Armaduras e Escudos cadastrados:</p>
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
        <tr *ngFor="let armaduraEscudo of armaduraEscudo">
          <td>{{armaduraEscudo.id}}</td>
          <td>{{armaduraEscudo.nome}}</td>
          <td>{{armaduraEscudo.bonusCa}}</td>
          <td>{{armaduraEscudo.bonusMaxDes}}</td>
          <td>{{armaduraEscudo.penalidade}}</td>
          <td>{{armaduraEscudo.categoria}}</td>
          <td>{{armaduraEscudo.peso}}</td>
          <td>{{armaduraEscudo.descricao}}</td>
          <td>
            <button class="button" (click)="editarArmaduraEscudo(armaduraEscudo.id)">
              <i class="fas fa-edit"></i>
            </button>
            <button class="button" (click)="removerArmaduraEscudo(armaduraEscudo.id)">
              <i class="fas fa-trash"></i>
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  `
})
export class ArmaduraEscudoListComponent implements OnInit {

  armaduraEscudo: ArmaduraEscudo[];
  constructor(
    private aventuraService: AventuraService
  ) {
  }

  ngOnInit() {
    this.aventuraService.findAllArmaduraEscudo().subscribe(e=>{
      this.armaduraEscudo = e;
    })
  }

  editarArmaduraEscudo(id:number){

  }

  removerArmaduraEscudo(id:number){
    this.aventuraService.removerArmaduraEscudo(id).subscribe(e=>{});
  }
}