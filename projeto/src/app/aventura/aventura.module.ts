import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
//import { ComponentesModule } from "app/componentes";
import { AventuraFormComponent } from './aventuras/aventura-form.component';
import { AventuraRoutingModule } from 'src/app/aventura/aventura-routing.module';
import { AventuraComponent } from 'src/app/aventura/aventura.component';
import { AventuraListComponent } from 'src/app/aventura/aventuras/aventura-list.component';
import { UsuarioService } from 'src/app/auth/services/usuario.service';
import { AventuraRouterComponent } from 'src/app/aventura/aventura-router.component';
import { RpgFormComponent } from './rpg/rpg-form.component';
import { AventuraService } from './services/aventuras.service';
import { RacaFormComponent } from './raca/raca-form.component';
import { RpgListComponent } from './rpg/rpg-list.component';
import { RacaListComponent } from './raca/raca-list.component';
import { HabilidadesRacaListComponent } from './habilidades-raca/habilidades-raca-list.component';
import { HabilidadesRacaFormComponent } from './habilidades-raca/habilidades-raca-form.component';
import { HabilidadeListComponent } from './habilidade/habilidade-list.component';
import { HabilidadeFormComponent } from './habilidade/habilidade-form.component';
import { PericiaFormComponent } from './pericia/pericia-form.component';
import { PericiaListComponent } from './pericia/pericia-list.component';
import { AtributoFormComponent } from './atributo/atributo-form.component';
import { AtributoListComponent } from './atributo/atributo-list.component';
import { ArmaduraEscudoListComponent } from './armadura-escudo/armaduraEscudo-list.component';
import { ArmaduraEscudoFormComponent } from './armadura-escudo/armaduraEscudo-form.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    //ComponentesModule,
    AventuraRoutingModule
  ],
  declarations: [
      AventuraComponent,
      AventuraRouterComponent,
      AventuraFormComponent,
      AventuraListComponent,
      RpgFormComponent,
      RpgListComponent,
      RacaFormComponent,
      RacaListComponent,
      HabilidadesRacaListComponent,
      HabilidadesRacaFormComponent,
      HabilidadeListComponent,
      HabilidadeFormComponent,
      AtributoListComponent,
      AtributoFormComponent,
      PericiaListComponent,
      PericiaFormComponent,
      ArmaduraEscudoListComponent,
      ArmaduraEscudoFormComponent
    ],
    providers: [AventuraService],  
  exports: [
      AventuraFormComponent,
      AventuraListComponent
  ]
  //,bootstrap: [AventuraComponent]
})
export class AventuraModule { }
