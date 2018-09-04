import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
//import { ComponentesModule } from "app/componentes";
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from 'src/app/auth/home.component';
import { AccessDeniedComponent } from 'src/app/auth/access-denied.component';
import { UsuarioListComponent } from 'src/app/auth/usuario-list.component';
import { UsuarioFormComponent } from 'src/app/auth/usuario-form.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    //ComponentesModule,
    BrowserModule,
    BrowserAnimationsModule
  ],
  declarations: [
        HomeComponent,
        AccessDeniedComponent,
        UsuarioListComponent,
        UsuarioFormComponent
    ],
  exports: [
      UsuarioListComponent,
      UsuarioFormComponent
  ]
})
export class AuthModule { }
