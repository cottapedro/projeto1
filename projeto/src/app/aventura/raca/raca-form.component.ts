import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators, FormBuilder} from '@angular/forms';
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
      public fb: FormBuilder,
      private aventuraService: AventuraService

    ) {
    }
   
    ngOnInit() {
      this.form = this.fb.group({
        nome: [{value: null, disabled: false}, [Validators.required]],
        descricao: [{value: null, disabled: false}, [Validators.required]],
        rpg: [{value: null, disabled: false}, [Validators.required]]
      })

      // this.form = new FormGroup({
      //   nome: new FormControl(''),
      //   descricao: new FormControl(''),
      //   rpg: new FormControl(null)
      // });
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
      rpg: <Rpg>{
        id: this.form.value.id,
        nome: this.form.value.nome,
        descricao: this.form.value.descricao,
      }
     }
     console.log(raca);
      this.aventuraService.salvarRaca(raca);
    }
  }