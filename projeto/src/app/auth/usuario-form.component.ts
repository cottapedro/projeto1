import { FormControl, FormGroup } from '@angular/forms';
import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import { UsuarioService } from 'src/app/auth/services/usuario.service';

@Component({
  selector: 'app-usuario-form',
  template: `
    <h1 (click)="testePost()">Componente do Form de Usuario</h1>
  `
})
export class UsuarioFormComponent implements OnInit {

  constructor(
    private usuarioService: UsuarioService
  ) {
  }

  testePost(){
    console.log('ebtrei no click!)');
    this.usuarioService.salvarItens();
  }

  ngOnInit() {
    //this.usuarioService.findUsuarioById(1).subscribe(e=>{
     // console.log(e);
    //})
  }
}