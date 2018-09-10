import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
//import { ComponentesModule } from "app/componentes";
import { AventuraFormComponent } from './aventuras/aventura-form.component';
import { AventuraRoutingModule } from 'src/app/aventura/aventura-routing.module';
import { AventuraComponent } from 'src/app/aventura/aventura.component';
import { AventuraListComponent } from 'src/app/aventura/aventuras/aventura-list.component';
import { UsuarioService } from 'src/app/auth/services/usuario.service';
import { AventuraRouterComponent } from 'src/app/aventura/aventura-router.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    //ComponentesModule,
    AventuraRoutingModule
  ],
  declarations: [
      AventuraComponent,
      AventuraRouterComponent,
      AventuraFormComponent,
      AventuraListComponent
    ],
  exports: [
      AventuraFormComponent,
      AventuraListComponent
  ]
  //,bootstrap: [AventuraComponent]
})
export class AventuraModule { }
