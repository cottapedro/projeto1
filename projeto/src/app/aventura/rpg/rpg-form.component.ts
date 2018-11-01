import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { AventuraService } from '../services/aventuras.service';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-rpg-form',
    templateUrl: './rpg-form.component.html'

  })
  export class RpgFormComponent implements OnInit {

    form: FormGroup;
  
    constructor(
      private route: ActivatedRoute,
      private aventuraService: AventuraService

    ) {
    }
   
    ngOnInit() {
      this.form = new FormGroup({
        id: new FormControl(null),
        nome: new FormControl('', Validators.minLength(2)),
        descricao: new FormControl('')
      });

      this.route.params.subscribe(e=>{
        if(e.id){
          this.atualizaForm(e.id);
        }
      });
    }

    atualizaForm(idRpg: number){
      this.aventuraService.findRpgById(idRpg).subscribe(e=>{
        this.form.get('id').setValue(e.id);
        this.form.get('nome').setValue(e.nome);
        this.form.get('descricao').setValue(e.descricao);
      });
    }

    onSubmit(): void{
     // console.log(this.form.value);
      this.aventuraService.salvarRpg(this.form.value);
    }
  }