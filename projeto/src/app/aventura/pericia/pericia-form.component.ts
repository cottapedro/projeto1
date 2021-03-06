import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators, FormBuilder} from '@angular/forms';
import { AventuraService } from '../services/aventuras.service';
import { Pericia } from '../services/pericia';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-pericia-form',
    templateUrl: './pericia-form.component.html'

  })
  export class PericiaFormComponent implements OnInit {

    form: FormGroup;
  
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
        descricao: [{value: null, disabled: false}, [Validators.required]],
        modificador: [{value: null, disabled: false}, [Validators.required]]
      })

      this.route.params.subscribe(e=>{
        if(e.id){
          this.atualizaForm(e.id);
        }
      });
    }

    atualizaForm(idPericia: number){
      this.aventuraService.findPericiaById(idPericia).subscribe(e=>{
        this.form.get('id').setValue(e.id);
        this.form.get('nome').setValue(e.nome);
        this.form.get('descricao').setValue(e.descricao);
        this.form.get('modificador').setValue(e.modificador);
      });
    }

    onSubmit(): void{
     
     let pericia =  <Pericia>{
      id: null,
      nome: this.form.value.nome,
      descricao: this.form.value.descricao,
      modificador: this.form.value.modificador
     }
      this.aventuraService.salvarPericia(pericia);
    }
  }