import { FormControl, FormGroup } from '@angular/forms';
import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import { Usuario } from 'src/app/auth/services/usuario';
import { UsuarioService } from 'src/app/auth/services/usuario.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-usuario-list',
  template: `
  <div class="casca">
    <h2>Componente do List de Usuario</h2>
    <p>meus usuarios cadastrados:</p>
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
        <tr *ngFor="let usuario of usuarios">
          <td>{{usuario.id}}</td>
          <td>{{usuario.nome}}</td>
          <td>{{usuario.email}}</td>
          <td>
            <button class="button" (click)="editarUsuario(usuario.id)">
              <i class="fas fa-edit"></i>
            </button>
            <button class="button" (click)="removerUsuario(usuario.id)">
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
    this.usuarioService.findAllUsuarios().subscribe(lstUsuarios=>{
      this.usuarios = lstUsuarios;
      console.log(lstUsuarios);
    })
  }

  editarUsuario(id:number){
    this.router.navigate([`app/usuario/form/${id}`]);
  }

  removerUsuario(id:number){
    this.usuarioService.removerUsuario(id).subscribe(e=>{});
  }
}