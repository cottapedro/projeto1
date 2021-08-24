import { Component, OnInit } from '@angular/core';
import { AventuraService } from '../services/aventuras.service';
import { Pericia } from '../services/pericia';
import { Router } from '@angular/router';


@Component({
  selector: 'app-pericia-list',
  template: `
  <div class="casca">
    <h2>Componente do List de Pericias</h2>
    <p>minhas pericias cadastrados:</p>
    <table class="table">
      <thead>
        <tr>
          <th>ID</th>
          <th>nome</th>
          <th>modificador</th>
          <th>penalidade de armadura</th>
          <th>somente treinada</th>
          <th>descrição</th>
          <th>opcões</th>
        </tr>
      </thead>
      <tbody>
        <tr *ngFor="let pericia of pericias">
          <td>{{pericia.id}}</td>
          <td>{{pericia.nome}}</td>
          <td>{{pericia.atributo.nome}}</td>
          <td>{{pericia.penalidadeArmadura}}</td>
          <td>{{pericia.somenteTreinada}}</td>
          <td>{{pericia.descricao}}</td>
          <td>
            <button class="button" (click)="editarPericia(pericia.id)">
              <i class="fas fa-edit"></i>
            </button>
            <button class="button" (click)="removerPericia(pericia.id)">
              <i class="fas fa-trash"></i>
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  `
})
export class PericiaListComponent implements OnInit {

  pericias: Pericia[];
  constructor(
    private router: Router,
    private aventuraService: AventuraService
  ) {
  }

  ngOnInit() {
    this.aventuraService.findAllPericias().subscribe(e=>{
      this.pericias = e;
    })
  }

  editarPericia(id:number){
    this.router.navigate([`app/pericia/form/${id}`]);
  }

  removerPericia(id:number){
    this.aventuraService.removerPericia(id).subscribe(e=>{
      alert('pericia excluida com sucesso!');
      this.ngOnInit();
    });
  }
}