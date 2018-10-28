import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { UsuarioService } from 'src/app/auth/services/usuario.service';

@Component({
  selector: 'app-usuario-form',
  template: `
    <h1 (click)="testePost()">Componente do Form de Usuario</h1>
    <form [formGroup]="form" (ngSubmit)="onSubmit()">
      <div *ngIf="nome?.invalid"> Minimo: 2 caracters </div>
 
      <input type="text" formControlName="nome" placeholder="Nome">
      <input type="password" formControlName="senha" placeholder="Senha">
      <input type="email" formControlName="email" placeholder="Email">
 
      <button type="submit">Submit</button>
    </form>
    <!--<button (click)="setValue()">Set preset value</button>-->
 
  `
})
// [formGroup]="form"
   // <div>
    //   <label>Nome</label>
    //   <input type="text" formControlName="nome"/>
    //   <label>E-mail</label>
    //   <input type="text" formControlName="email"/>
    //   <label>Senha</label>
    //   <input type="text" formControlName="senha"/>
    // </div>
export class UsuarioFormComponent implements OnInit {

  form: FormGroup;

  constructor(
    private usuarioService: UsuarioService,
    //protected fb: FormBuilder
  ) {
  }

  testePost(){
    console.log('ebtrei no click!)');
    this.usuarioService.salvarItens();
  }

  ngOnInit() {
    this.form = new FormGroup({
      nome: new FormControl('', Validators.minLength(2)),
      senha: new FormControl(''),
      email: new FormControl(''),
    });
    // this.form = this.fb.group({
    //   id: this.fb.control(null),
    //   nome: this.fb.control(null),
    //   senha: this.fb.control(null),
    //   email: this.fb.control(null)
    // });
  }

  onSubmit(): void {
    console.log(this.form.value);
    this.usuarioService.salvarUsuario(this.form.value);
  }
}