import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { AventuraService } from '../services/aventuras.service';

@Component({
    selector: 'app-rpg-form',
    templateUrl: './rpg-form.component.html'

  })
  export class RpgFormComponent implements OnInit {

    form: FormGroup;
  
    constructor(
      private aventuraService: AventuraService

    ) {
    }
   
    ngOnInit() {
      this.form = new FormGroup({
        nome: new FormControl('', Validators.minLength(2)),
        descricao: new FormControl('')
      });
    }
    onSubmit(): void{
     // console.log(this.form.value);
      this.aventuraService.salvarRpg(this.form.value);
    }
  }