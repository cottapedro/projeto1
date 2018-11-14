import { Component, OnInit } from '@angular/core';
import { AventuraService } from '../services/aventuras.service';
import { Rpg } from '../services/rpg';
import { Router } from '@angular/router';


@Component({
  selector: 'app-rpg-list',
  template: `
  <div class="casca">
    <h2>Componente do List de RPG</h2>
    <p>meus rpgs cadastrados:</p>
    <table class="table">
      <thead>
        <tr>
          <th>ID</th>
          <th>nome</th>
          <th>email</th>
          <th>opcões</th>
        </tr>
      </thead>
      <tbody>
        <tr *ngFor="let rpg of rpgs">
          <td>{{rpg.id}}</td>
          <td>{{rpg.nome}}</td>
          <td>{{rpg.descricao}}</td>
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
export class RpgListComponent implements OnInit {

  rpgs: Rpg[];
  constructor(
    private router: Router,
    private aventuraService: AventuraService
  ) {
  }

  ngOnInit() {
    this.aventuraService.findAllRpgs().subscribe(e=>{
      this.rpgs = e;
    })
  }

  editarRpg(id:number){
    this.router.navigate([`app/rpg/form/${id}`]);
  }

  removerRpg(id:number){
    this.aventuraService.removerRpg(id).subscribe(e=>{});
  }
}