import { NgModule } from '@angular/core';
import { Route, RouterModule, Routes } from '@angular/router';
import { AccessDeniedComponent } from 'src/app/auth/access-denied.component';
import { ContentComponent } from 'src/app/content.component';
import { HomeComponent } from 'src/app/auth/home.component';
import { LoginComponent } from 'src/app/auth/login.component';
import { AventuraFormComponent } from './aventura/aventuras/aventura-form.component';
import { AventuraModule } from 'src/app/aventura/aventura.module';
import { AventuraListComponent } from './aventura/aventuras/aventura-list.component';
import { UsuarioListComponent } from './auth/usuario-list.component';
import { UsuarioFormComponent } from './auth/usuario-form.component';
import { RpgFormComponent } from './aventura/rpg/rpg-form.component';
import { RacaFormComponent } from './aventura/raca/raca-form.component';
import { RacaListComponent } from './aventura/raca/raca-list.component';
import { RpgListComponent } from './aventura/rpg/rpg-list.component';
import { HabilidadesRacaListComponent } from './aventura/habilidades-raca/habilidades-raca-list.component';
import { HabilidadesRacaFormComponent } from './aventura/habilidades-raca/habilidades-raca-form.component';
import { HabilidadeListComponent } from './aventura/habilidade/habilidade-list.component';
import { HabilidadeFormComponent } from './aventura/habilidade/habilidade-form.component';
import { PericiaListComponent } from './aventura/pericia/pericia-list.component';
import { PericiaFormComponent } from './aventura/pericia/pericia-form.component';
import { AtributoListComponent } from './aventura/atributo/atributo-list.component';
import { AtributoFormComponent } from './aventura/atributo/atributo-form.component';
import { ArmaduraEscudoListComponent } from './aventura/armadura-escudo/armaduraEscudo-list.component';
import { ArmaduraEscudoFormComponent } from './aventura/armadura-escudo/armaduraEscudo-form.component';

// const ACCESS_DENIED_ROUTE: Route = {
//   path: 'access-denied',
//   component: AccessDeniedComponent
// };

//path: 'aventura', loadChildren: 'app/aventura/aventura.module#AventuraModule'
//path: 'aventura', loadChildren: ()=> AventuraModule

const LOGIN_ROUTE: Route = {
  path: 'login',
  component: LoginComponent,
};

const APP_ROUTE: Route = {
  path: 'app',
  component: ContentComponent,
  children: [{
    path: 'home', component: HomeComponent
  }
  // ,{path: 'aventura/listar', component: AventuraListComponent}
  // ,{path: 'aventura/form', component: AventuraFormComponent}
  ,{path: 'usuario/listar', component: UsuarioListComponent}
  ,{path: 'usuario/form', component: UsuarioFormComponent}
  ,{path: 'usuario/form/:id', component: UsuarioFormComponent}
  ,{path: 'rpg/list', component: RpgListComponent}
  ,{path: 'rpg/form', component: RpgFormComponent}
  ,{path: 'rpg/form/:id', component: RpgFormComponent}
  ,{path: 'raca/list', component: RacaListComponent}
  ,{path: 'raca/form', component: RacaFormComponent}
  ,{path: 'habilidades-raca/list', component: HabilidadesRacaListComponent}
  ,{path: 'habilidades-raca/form', component: HabilidadesRacaFormComponent}
  ,{path: 'habilidade/list', component: HabilidadeListComponent}
  ,{path: 'habilidade/form', component: HabilidadeFormComponent}
  ,{path: 'pericia/list', component: PericiaListComponent}
  ,{path: 'pericia/form', component: PericiaFormComponent}
  ,{path: 'pericia/form/:id', component: PericiaFormComponent}
  ,{path: 'armaduraEscudo/list', component: ArmaduraEscudoListComponent}
  ,{path: 'armaduraEscudo/form', component: ArmaduraEscudoFormComponent}
  ,{path: 'armaduraEscudo/form/:id', component: ArmaduraEscudoFormComponent}
  ,{path: 'atributo/list', component: AtributoListComponent}
  ,{path: 'atributo/form', component: AtributoFormComponent}
  ,{path: 'atributo/form/:id', component: AtributoFormComponent}
  
  ,{path: 'principal', loadChildren: ()=> AventuraModule
  }
  ,{path: '**', component: AccessDeniedComponent}]
};

const appRoutes: Routes = [
  LOGIN_ROUTE,
  APP_ROUTE,
  { path: '', redirectTo: '/app/home', pathMatch: 'full' }
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes, { relativeLinkResolution: 'legacy' })
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
