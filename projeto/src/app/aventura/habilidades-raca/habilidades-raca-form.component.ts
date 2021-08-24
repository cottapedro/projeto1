import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators, FormBuilder} from '@angular/forms';
import { AtributoListComponent } from '../atributo/atributo-list.component';
import { AventuraService } from '../services/aventuras.service';
import { HabilidadesRaca } from '../services/habilidadeRaca';
import { Raca } from '../services/raca';
import { Atributo } from '../services/atributo';

@Component({
    selector: 'app-habilidades-raca-form',
    templateUrl: './habilidades-raca-form.component.html'

  })
  export class HabilidadesRacaFormComponent implements OnInit {

    lstRacas: Raca[];
    atributos: Atributo[];
    form: FormGroup;
  
    constructor(
      public fb: FormBuilder,
      private aventuraService: AventuraService

    ) {
    }

    carregaListaDeRacas(){
      this.aventuraService.findAllRacas().subscribe(e=>{
          this.lstRacas = e;
      })
    }

    carregaAtributos(){
      this.aventuraService.findAllAtributos().subscribe(e=>{
          this.atributos = e;
      })
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
      this.carregaListaDeRacas();
      this.carregaAtributos();
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