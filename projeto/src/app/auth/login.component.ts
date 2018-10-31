import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { UsuarioService } from 'src/app/auth/services/usuario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  template: `
  <div class="casca">
    <form [formGroup]="form" (ngSubmit)="onSubmit()">
  <!--  <img src="././assets/img/epicquest.png"/> -->
  <div class="field">
    <label class="label">Nome</label>
    <div class="control">
      <input class="input" type="text" formControlName="username" placeholder="Úsuario">
    </div>
  </div>
  <div class="field">
    <label class="label">Senha</label>
    <div class="control">
      <input class="input" type="password" formControlName="password" placeholder="Senha">
    </div>
  </div>
  <div class="field is-grouped">
    <!--<div class="control">
      <button class="button is-link" (click)="setValue()">Set preset value</button>
    </div> -->
    <div class="control">
      <button (click)="navegarPara('usuario/form')" class="button is-text">Não é cadastrado? Registre agora.</button>
    </div>
    <div class="control">
      <button class="button is-primary" type="submit">logar</button>
    </div>
  </div>   
    </form>
    </div>
  `
})
export class LoginComponent implements OnInit {

  form: FormGroup;

  constructor(
    private router: Router,
    private usuarioService: UsuarioService
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

  navegarPara(destino:string){
    this.router.navigate([`app/${destino}`]);
  }

  onSubmit(): void {
    console.log(this.form.value);
    this.usuarioService.login(this.form.value);
  }
}