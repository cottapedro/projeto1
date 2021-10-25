import { Component, OnInit } from '@angular/core';
import { AventuraService } from '../services/aventuras.service';
import { Role } from '../services/role';


@Component({
  selector: 'app-role-list',
  template: `
  <div class="casca">
    <h2>Componente do List de Roles</h2>
    <p>minhas roles cadastrados:</p>
    <table class="table">
      <thead>
        <tr>
          <th>ID</th>
          <th>nome</th>
          <th>descrição</th>
          <th>mestre</th>
          <th>opcões</th>
        </tr>
      </thead>
      <tbody>
        <tr *ngFor="let role of roles">
          <td>{{role.id}}</td>
          <td>{{role.nome}}</td>
          <td>{{role.descricao}}</td>
          <td>{{role.usuario.nome}}</td>
          <td>
            <button class="button" (click)="editarRole(role.id)">
              <i class="fas fa-edit"></i>
            </button>
            <button class="button" (click)="removerRole(role.id)">
              <i class="fas fa-trash"></i>
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  `
})
export class RoleListComponent implements OnInit {

  roles: Role[];
  constructor(
    private aventuraService: AventuraService
  ) {
  }

  ngOnInit() {
    this.aventuraService.findAllRoles().subscribe(e=>{
      this.roles = e;
    })
  }

  editarRole(id:number){

  }

  removerRole(id:number){
    this.aventuraService.removerRole(id).subscribe(e=>{
      alert('raça excluida com sucesso!');
      this.ngOnInit();
    });
  }
}