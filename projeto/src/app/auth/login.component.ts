import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { UsuarioService } from 'src/app/auth/services/usuario.service';

@Component({
  selector: 'app-login',
  template: `
    <h1>Bora L-O-G-A-R</h1>
    <form [formGroup]="form" (ngSubmit)="onSubmit()">
 
    <input type="text" formControlName="username" placeholder="Usuario">
      <input type="password" formControlName="password" placeholder="Senha">
 
      <button type="submit">logar</button>
    </form>
    <button (click)="setValue()">Set preset value</button>
 
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
export class LoginComponent implements OnInit {

  form: FormGroup;

  constructor(
    private usuarioService: UsuarioService,
    //protected fb: FormBuilder
  ) {
  }

  ngOnInit() {
    this.form = new FormGroup({
      username: new FormControl(''),
      password: new FormControl(''),
    });
  }

  setValue(){
    this.form.setValue({username:"doutor",password:"123456"});
  }

  onSubmit(): void {
    console.log(this.form.value);
    this.usuarioService.login(this.form.value);
  }
}