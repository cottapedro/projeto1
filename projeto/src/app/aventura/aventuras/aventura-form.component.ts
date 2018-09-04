import { FormControl, FormGroup } from '@angular/forms';
import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import { UsuarioService } from 'src/app/auth/services/usuario.service';

@Component({
  selector: 'app-aventura-form',
  template: `
    <h1>Componente do Form da Aventura</h1>
  `
})
export class AventuraFormComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }
}