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
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
