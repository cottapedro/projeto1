import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators, FormBuilder} from '@angular/forms';
import { AventuraService } from '../services/aventuras.service';
import { Role } from '../services/role';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-role-form',
    templateUrl: './role-form.component.html'

  })
  export class RoleFormComponent implements OnInit {

    form: FormGroup;
    roles: Role[];
  
    constructor(
      public fb: FormBuilder,
      private route: ActivatedRoute,
      private aventuraService: AventuraService

    ) {
    }
   
    ngOnInit() {
      this.form = this.fb.group({
        id: new FormControl(null),
        nome: [{value: null, disabled: false}, [Validators.required]],
        descricao: [{value: null, disabled: false}, [Validators.required]]
      })

      //this.carregaListaDeAtributos();

      this.route.params.subscribe(e=>{
        if(e.id){
          this.atualizaForm(e.id);
        }
      });
    }
    
    // carregaListaDeAtributos(){
    //   this.aventuraService.findAllAtributos().subscribe(e=>{
    //       this.atributos = e;
    //   })
    // }

    atualizaForm(id: number){
      this.aventuraService.findRoleById(id).subscribe(e=>{
        this.form.get('id').setValue(e.id);
        this.form.get('nome').setValue(e.nome);
        this.form.get('descricao').setValue(e.descricao);
      });
    }

    onSubmit(): void{
     
     let role =  <Role>{
      id: null,
      nome: this.form.value.nome,
      descricao: this.form.value.descricao,
     }
      this.aventuraService.salvarRole(role);
    }
  }