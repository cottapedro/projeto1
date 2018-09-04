import { NgModule } from '@angular/core';
import { RouterModule, Routes, Route } from '@angular/router';
import { AventuraComponent } from './aventura.component';
import { AventuraFormComponent } from 'src/app/aventura/aventuras/aventura-form.component';
import { AventuraListComponent } from 'src/app/aventura/aventuras/aventura-list.component';
import { AventuraRouterComponent } from 'src/app/aventura/aventura-router.component';

const AVENTURA_ROUTE: Route = {
  path: 'aventura',
  component: AventuraRouterComponent,
  children: [{
    path: 'listar',
    component: AventuraListComponent
  },{
    path: 'form',
    component: AventuraFormComponent
  }]
};

const aventuraRoutes: Routes = [{
  path: '',
  //path: 'aventura',
  component: AventuraComponent,
  children: [
    AVENTURA_ROUTE
    //{path: 'listar', component: AventuraListComponent}
  ]
}];

@NgModule({
  imports: [
    RouterModule.forChild(aventuraRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AventuraRoutingModule { }