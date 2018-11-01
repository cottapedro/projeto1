import { Component, OnInit, AfterViewInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { UsuarioService } from 'src/app/auth/services/usuario.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Usuario } from './services/usuario';

@Component({
  selector: 'app-usuario-form',
  template: `
    <div class="casca">
    <h2>Componente do Form de Usuario</h2>
    <form [formGroup]="form" (ngSubmit)="onSubmit()">
      <!-- <div *ngIf="nome?.invalid"> Minimo: 2 caracters </div> -->
      <div class="field">
        <label class="label">Nome</label>
        <div class="control">
          <input class="input" type="text" formControlName="nome" placeholder="Nome">
        </div>
      </div>
      <div class="field">
        <label class="label">Senha</label>
        <div class="control">
          <input class="input" type="password" formControlName="senha" placeholder="Senha">
        </div>
      </div>
      <div class="field">
        <label class="label">Email</label>
        <div class="control">
          <input class="input" type="email" formControlName="email" placeholder="Email">
        </div>
      </div>
      <div class="field">
        <button class="button is-primary" type="submit">Salvar</button>
      </div>
    </form>
    </div> 
 
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
export class UsuarioFormComponent implements OnInit, AfterViewInit {

  form: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private usuarioService: UsuarioService,
    //protected fb: FormBuilder
  ) {
  }

  testePost(){
    console.log('ebtrei no click!)');
    this.usuarioService.salvarItens();
  }

  ngAfterViewInit(){
    // this.route.params.map(e=>{
    //   console.log(e.get('id'));
    //   if(e.get('id')){
    //     this.atualizaForm(e.get('id'));
    //   }
    // })
  }

  ngOnInit() {
    this.form = new FormGroup({
      id: new FormControl(null),
      nome: new FormControl('', Validators.minLength(2)),
      senha: new FormControl(''),
      email: new FormControl(''),
    });

    this.route.params.subscribe(e=>{
      console.log(e);
      if(e.id){
        console.log('oiee', e.id);
        this.atualizaForm(e.id);
      }
    });
  }

  atualizaForm(idUsuario: number){
    console.log('atualizando');
    this.usuarioService.findUsuarioById(idUsuario).subscribe(e=>{
      console.log('usuario por id:', e);
      this.form.get('id').setValue(e.id);
      this.form.get('nome').setValue(e.nome);
      this.form.get('email').setValue(e.email);
      this.form.get('senha').setValue(e.senha);
    });
  }

  onSubmit(): void {
    console.log(this.form.value);
    let usuario =  <Usuario>{
      id: this.form.value.id,
      nome: this.form.value.nome,
      senha: this.form.value.senha,
      email: this.form.value.email
     }
    this.usuarioService.salvarUsuario(usuario);
  }
}