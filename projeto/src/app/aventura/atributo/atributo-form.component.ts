import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators, FormBuilder} from '@angular/forms';
import { AventuraService } from '../services/aventuras.service';
import { Atributo } from '../services/atributo';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-atributo-form',
    templateUrl: './atributo-form.component.html'

  })
  export class AtributoFormComponent implements OnInit {

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
        sigla: [{value: null, disabled: false}, [Validators.required]]
      })

      this.route.params.subscribe(e=>{
        if(e.id){
          this.atualizaForm(e.id);
        }
      });
    }

    atualizaForm(idAtributo: number){
      this.aventuraService.findAtributoById(idAtributo).subscribe(e=>{
        this.form.get('id').setValue(e.id);
        this.form.get('nome').setValue(e.nome);
        this.form.get('sigla').setValue(e.sigla);
      });
    }

    onSubmit(): void{
     
     let atributo =  <Atributo>{
      id: null,
      nome: this.form.value.nome,
      sigla: this.form.value.sigla,
     }
      this.aventuraService.salvarAtributo(atributo);
    }
  }