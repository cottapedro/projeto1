import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { AventuraService } from '../services/aventuras.service';
import { Rpg } from '../services/rpg';
import { Raca } from '../services/raca';

@Component({
    selector: 'app-raca-form',
    templateUrl: './raca-form.component.html'

  })
  export class RacaFormComponent implements OnInit {

    form: FormGroup;
    lstRpg: Rpg[];
  
    constructor(
      private aventuraService: AventuraService

    ) {
    }
   
    ngOnInit() {
      this.form = new FormGroup({
        nome: new FormControl(''),
        descricao: new FormControl(''),
        rpg: new FormControl()
      });
      this.carregaListaDeRpgs();
    }

    carregaListaDeRpgs(){
      this.aventuraService.findAllRpgs().subscribe(e=>{
          this.lstRpg = e;
      })
    }

    onSubmit(): void{
     
     let raca =  <Raca>{
      id: null,
      nome: this.form.value.nome,
      descricao: this.form.value.descricao,
      rpg: this.form.value.rpg
     }
     console.log(raca);
      this.aventuraService.salvarRaca(raca);
    }
  }