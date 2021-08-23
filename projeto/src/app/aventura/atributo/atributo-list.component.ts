import { Component, OnInit } from '@angular/core';
import { AventuraService } from '../services/aventuras.service';
import { Atributo } from '../services/atributo';
import { Router } from '@angular/router';


@Component({
  selector: 'app-atributo-list',
  template: `
  <div class="casca">
    <h2>Componente do List de Atributos</h2>
    <p>meus atributos cadastrados:</p>
    <table class="table">
      <thead>
        <tr>
          <th>ID</th>
          <th>nome</th>
          <th>sigla</th>
          <th>opcões</th>
        </tr>
      </thead>
      <tbody>
        <tr *ngFor="let atributo of atributos">
          <td>{{atributo.id}}</td>
          <td>{{atributo.nome}}</td>
          <td>{{atributo.sigla}}</td>
          <td>
            <button class="button" (click)="editarAtributo(atributo.id)">
              <i class="fas fa-edit"></i>
            </button>
            <button class="button" (click)="removerAtributo(atributo.id)">
              <i class="fas fa-trash"></i>
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  `
})
export class AtributoListComponent implements OnInit {

  atributos: Atributo[];
  constructor(
    private router: Router,
    private aventuraService: AventuraService
  ) {
  }

  ngOnInit() {
    this.aventuraService.findAllAtributos().subscribe(e=>{
      this.atributos = e;
    })
  }

  editarAtributo(id:number){
    this.router.navigate([`app/atributo/form/${id}`]);
  }

  removerAtributo(id:number){
    this.aventuraService.removerAtributo(id).subscribe(e=>{
      alert('atributo excluido com sucesso!');
      this.ngOnInit();
    });
  }
}