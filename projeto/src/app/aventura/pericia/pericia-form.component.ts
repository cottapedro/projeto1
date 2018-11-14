import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators, FormBuilder} from '@angular/forms';
import { AventuraService } from '../services/aventuras.service';
import { Pericia } from '../services/pericia';

@Component({
    selector: 'app-pericia-form',
    templateUrl: './pericia-form.component.html'

  })
  export class PericiaFormComponent implements OnInit {

    form: FormGroup;
  
    constructor(
      public fb: FormBuilder,
      private aventuraService: AventuraService

    ) {
    }
   
    ngOnInit() {
      this.form = this.fb.group({
        nome: [{value: null, disabled: false}, [Validators.required]],
        descricao: [{value: null, disabled: false}, [Validators.required]]
        modificador: [{value: null, disabled: false}, [Validators.required]]
      })
    }

  

    onSubmit(): void{
     
     let pericia =  <Pericia>{
      id: null,
      nome: this.form.value.nome,
      descricao: this.form.value.descricao,
      modificador: this.form.value.descricao
     }
      this.aventuraService.salvarPericia(pericia);
    }
  }