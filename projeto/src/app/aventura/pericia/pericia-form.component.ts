import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators, FormBuilder} from '@angular/forms';
import { AventuraService } from '../services/aventuras.service';
import { Pericia } from '../services/pericia';
import { Atributo } from '../services/atributo';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-pericia-form',
    templateUrl: './pericia-form.component.html'

  })
  export class PericiaFormComponent implements OnInit {

    form: FormGroup;
    atributos: Atributo[];
  
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
        somenteTreinada: [{value: null, disabled: false}, [Validators.required]],
        penalidadeArmadura: [{value: null, disabled: false}, [Validators.required]],
        atributo: [{value: null, disabled: false}, [Validators.required]]
      })

      this.carregaListaDeAtributos();

      this.route.params.subscribe(e=>{
        if(e.id){
          this.atualizaForm(e.id);
        }
      });
    }
    carregaListaDeAtributos(){
      this.aventuraService.findAllAtributos().subscribe(e=>{
          this.atributos = e;
      })
    }

    atualizaForm(idPericia: number){
      this.aventuraService.findPericiaById(idPericia).subscribe(e=>{
        this.form.get('id').setValue(e.id);
        this.form.get('nome').setValue(e.nome);
        this.form.get('descricao').setValue(e.descricao);
        this.form.get('atributo').setValue(e.atributo);
        this.form.get('somenteTreinada').setValue(e.somenteTreinada);
        this.form.get('penalidadeArmadura').setValue(e.penalidadeArmadura);
      });
    }

    onSubmit(): void{
     
     let pericia =  <Pericia>{
      id: null,
      nome: this.form.value.nome,
      descricao: this.form.value.descricao,
      somenteTreinada: this.form.value.somenteTreinada,
      penalidadeArmadura: this.form.value.penalidadeArmadura,
      atributo: <Atributo>{
        id: this.form.value.atributo.id,
        nome: this.form.value.atributo.nome,
        sigla: this.form.value.atributo.sigla,
      }
     }
      this.aventuraService.salvarPericia(pericia);
    }
  }