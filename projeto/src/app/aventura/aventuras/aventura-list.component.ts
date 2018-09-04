import { FormControl, FormGroup } from '@angular/forms';
import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import { UsuarioService } from '../../auth/services/usuario.service';
import { Usuario } from '../../auth/services/usuario';

@Component({
  selector: 'app-aventura-list',
  template: `
    <h1>Componente do List da Aventura</h1>
  `
})
export class AventuraListComponent implements OnInit {

  usuarios: Usuario[];

  constructor() {
  }

  ngOnInit() {}
}