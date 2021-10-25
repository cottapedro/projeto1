import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { UsuarioService } from '../services/usuario.service';
import { Usuario } from '../services/usuario';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-usuario-form',
    templateUrl: './usuario-form.component.html'

  })
  export class UsuarioFormComponent implements OnInit {

    form: FormGroup;
  
    constructor(
      private route: ActivatedRoute,
      private usuarioService: UsuarioService

    ) {
    }
   
    ngOnInit() {
      this.form = new FormGroup({
        id: new FormControl(null),
        nome: new FormControl('', Validators.minLength(2)),
        email: new FormControl(''),
        login: new FormControl(''),
        senha: new FormControl('')
      });

      this.route.params.subscribe(e=>{
        if(e.id){
          this.atualizaForm(e.id);
        }
      });
    }

    atualizaForm(idUsuario: number){
      this.usuarioService.findUsuarioById(idUsuario).subscribe(e=>{
        this.form.get('id').setValue(e.id);
        this.form.get('nome').setValue(e.nome);
        this.form.get('email').setValue(e.email);
        this.form.get('login').setValue(e.login);
        this.form.get('senha').setValue(e.senha);
      });
    }

    onSubmit(): void{
     // console.log(this.form.value);
     let usuario =  <Usuario>{
      id: null,
      nome: this.form.value.nome,
      email: this.form.value.email,
      login: this.form.value.login,
      senha: this.form.value.login
     }

      this.usuarioService.salvarUsuario(usuario);
    }
  }