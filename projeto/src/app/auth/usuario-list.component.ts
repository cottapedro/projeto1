import { FormControl, FormGroup } from '@angular/forms';
import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import { Usuario } from 'src/app/auth/services/usuario';
import { UsuarioService } from 'src/app/auth/services/usuario.service';


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
        </tr>
      </thead>
      <tbody>
        <tr *ngFor="let usuario of usuarios">
          <td>{{usuario.id}}</td>
          <td>{{usuario.nome}}</td>
          <td>{{usuario.email}}</td>
        </tr>
      </tbody>
    </table>
  </div>
  `
})
export class UsuarioListComponent implements OnInit {

  usuarios: Usuario[];
  constructor(
    private usuarioService: UsuarioService
  ) {
  }

  ngOnInit() {
    this.usuarioService.findAllUsuarios().subscribe(lstUsuarios=>{
      this.usuarios = lstUsuarios;
      console.log(lstUsuarios);
    })
  }
}