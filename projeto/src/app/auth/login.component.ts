import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { UsuarioService } from 'src/app/auth/services/usuario.service';

@Component({
  selector: 'app-login',
  template: `
  <div class="flex-center">
    <form [formGroup]="form" (ngSubmit)="onSubmit()" class="login-container">
    <img src="././assets/img/epicquest.png"/>
      <div class="form-group">
        <div class="binput"><input type="text" formControlName="username" placeholder="Enter Username"></div>
      </div>
      <div class="form-group">
        <div class="binput"><input type="password" formControlName="password" placeholder="Enter Password"></div>
      </div>
      <div class="btn-actions">
        <button (click)="setValue()">Set preset value</button>
        <button type="submit">logar</button>
      </div>
    </form>
  </div>
  `
})
export class LoginComponent implements OnInit {

  form: FormGroup;

  constructor(
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

  onSubmit(): void {
    console.log(this.form.value);
    this.usuarioService.login(this.form.value);
  }
}