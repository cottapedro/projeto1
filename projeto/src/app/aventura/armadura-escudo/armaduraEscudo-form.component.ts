import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators, FormBuilder} from '@angular/forms';
import { AventuraService } from '../services/aventuras.service';
import { ArmaduraEscudo } from '../services/armaduraEscudo';

@Component({
    selector: 'app-armaduraEscudo-form',
    templateUrl: './armaduraEscudo-form.component.html'

  })
  export class ArmaduraEscudoFormComponent implements OnInit {

    form: FormGroup;
  
    constructor(
      public fb: FormBuilder,
      private aventuraService: AventuraService

    ) {
    }
   
    ngOnInit() {
      this.form = this.fb.group({
        nome: [{value: null, disabled: false}, [Validators.required]],
        bonusCa: [{value: null, disabled: false}, [Validators.required]],
        bonusMaxDes: [{value: null, disabled: false}, [Validators.required]],
        penalidade: [{value: null, disabled: false}, [Validators.required]],
        categoria: [{value: null, disabled: false}, [Validators.required]],
        peso: [{value: null, disabled: false}, [Validators.required]],
        descricao: [{value: null, disabled: false}, [Validators.required]]

      })
    }


    onSubmit(): void{
     
     let armaduraEscudo =  <ArmaduraEscudo>{
      id: null,
      nome: this.form.value.nome,
      bonusCa: this.form.value.bonusCA,
      bonusMaxDes: this.form.value.bonusMaxDes,
      penalidade: this.form.value.penalidade,
      categoria: this.form.value.categoria,
      peso: this.form.value.peso,
      descricao: this.form.value.descricao,
     }
     console.log(armaduraEscudo);
      this.aventuraService.salvarArmaduraEscudo(armaduraEscudo);
    }
  }