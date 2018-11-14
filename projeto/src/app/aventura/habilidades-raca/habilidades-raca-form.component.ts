import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators, FormBuilder} from '@angular/forms';
import { AventuraService } from '../services/aventuras.service';
import { HabilidadesRaca } from '../services/habilidadeRaca';
import { Raca } from '../services/raca';

@Component({
    selector: 'app-habilidades-raca-form',
    templateUrl: './habilidades-raca-form.component.html'

  })
  export class HabilidadesRacaFormComponent implements OnInit {

    form: FormGroup;
  
    constructor(
      public fb: FormBuilder,
      private aventuraService: AventuraService

    ) {
    }
   
    ngOnInit() {
      this.form = this.fb.group({
        nome: [{value: null, disabled: false}, [Validators.required]],
        tipoHabilidade: [{value: null, disabled: false}, [Validators.required]],
        valor: [{value: null, disabled: false}, [Validators.required]],
        skill: [{value: null, disabled: false}, [Validators.required]],
        descricao: [{value: null, disabled: false}, [Validators.required]],
        raca: [{value: null, disabled: false}, [Validators.required]]
      })
    }
    
    onSubmit(): void{
     
      let habilidadeRaca =  <HabilidadesRaca>{

       id: null,
       nome: this.form.value.nome,
       descricao: this.form.value.descricao,
       tipoHabilidade: this.form.value.tipoHabilidade,
       valor: this.form.value.valor,
       skill: this.form.value.skill,
       raca: <Raca>{
         id: this.form.value.raca.id,
         //nome: this.form.value.raca.nome,
         //descricao: this.form.value.raca.descricao,
       }
      }
       this.aventuraService.salvarHabilidadesRaca(habilidadeRaca);
     }
  }