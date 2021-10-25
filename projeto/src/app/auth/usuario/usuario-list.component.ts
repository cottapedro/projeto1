import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../services/usuario.service';
import { Usuario } from '../services/usuario';
import { Router } from '@angular/router';


@Component({
  selector: 'app-usuario-list',
  template: `
  <div class="casca">
    <h2>Componente do List de Usuarios</h2>
    <p>meus usuarios cadastrados:</p>
    <table class="table">
      <thead>
        <tr>
          <th>ID</th>
          <th>nome</th>
          <th>login</th>
          <th>senha</th>
          <th>email</th>
          <th>opcões</th>
        </tr>
      </thead>
      <tbody>
        <tr *ngFor="let usuario of usuarios">
          <td>{{usuario.id}}</td>
          <td>{{usuario.nome}}</td>
          <td>{{usuario.login}}</td>
          <td>{{usuario.senha}}</td>
          <td>{{usuario.email}}</td>
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
export class UsuarioListComponent implements OnInit {

  usuarios: Usuario[];

  constructor(
    private router: Router,
    private usuarioService: UsuarioService
  ) {
  }

  ngOnInit() {
    this.usuarioService.findAllUsuarios().subscribe(e=>{
      this.usuarios = e;
    })
  }

  editarRpg(id:number){
    this.router.navigate([`app/rpg/form/${id}`]);
  }

  removerRpg(id:number){
    this.usuarioService.removerUsuario(id).subscribe(e=>{
      alert('usuario excluido com sucesso!');
      this.ngOnInit();
    });
  }
}