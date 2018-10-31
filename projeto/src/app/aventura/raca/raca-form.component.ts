import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { AventuraService } from '../services/aventuras.service';
import { Rpg } from '../services/rpg';

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
        rpg: new FormControl('')
      });
    }

    carregaListaDeRpgs(){
      this.aventuraService.findAllRpgs().subscribe(e=>{
        this.lstRpg = e;
      })
    }

    onSubmit(): void{
     // console.log(this.form.value);
      this.aventuraService.salvarRaca(this.form.value);
    }
  }