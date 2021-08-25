import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators, FormBuilder} from '@angular/forms';
import { AventuraService } from '../services/aventuras.service';
import { Habilidade } from '../services/habilidade';
import { Atributo } from '../services/atributo';
import { HabilidadesRaca } from '../services/habilidadeRaca';

@Component({
    selector: 'app-habilidade-form',
    templateUrl: './habilidade-form.component.html'

  })
  export class HabilidadeFormComponent implements OnInit {

    atributos: Atributo[];
    lstHabilidadesRaca: HabilidadesRaca[]; 
    form: FormGroup;
  
    constructor(
      public fb: FormBuilder,
      private aventuraService: AventuraService

    ) {
    }

    carregaAtributos(){
      this.aventuraService.findAllAtributos().subscribe(e=>{
          this.atributos = e;
      })
    }

    carregaHabilidadesRaca(){
      this.aventuraService.findAllHabilidadesRaca().subscribe(e=>{
          this.lstHabilidadesRaca = e;
      })
    }
   
    ngOnInit() {
      this.form = this.fb.group({
        tipoHabilidade: [{value: null, disabled: false}, [Validators.required]],
        valor: [{value: null, disabled: false}, [Validators.required]],
        skill: [{value: null, disabled: false}, [Validators.required]],
        descricao: [{value: null, disabled: false}, [Validators.required]]
      })
      this.carregaAtributos();
      this.carregaHabilidadesRaca();
    }
    
    onSubmit(): void{

      // this.atributos.map(atributo =>{
      //   this.form.value.atributo
      // })
     
      let habilidade =  <Habilidade>{

       id: null,
       descricao: this.form.value.descricao,
       tipoHabilidade: this.form.value.tipoHabilidade,
       valor: this.form.value.valor,
       skill: this.form.value.skill
      }
       this.aventuraService.salvarHabilidade(habilidade);
     }
  }