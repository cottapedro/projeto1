import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
//import { ComponentesModule } from "app/componentes";
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from 'src/app/auth/home.component';
import { LoginComponent } from 'src/app/auth/login.component';
import { AccessDeniedComponent } from 'src/app/auth/access-denied.component';
import { UsuarioListComponent } from 'src/app/auth/usuario/usuario-list.component';
import { UsuarioFormComponent } from 'src/app/auth/usuario/usuario-form.component';
import { UsuarioService } from './services/usuario.service';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    //ComponentesModule,
    BrowserModule,
    BrowserAnimationsModule
  ],
  declarations: [
        HomeComponent,
        LoginComponent,
        AccessDeniedComponent,
        UsuarioListComponent,
        UsuarioFormComponent
    ],
  providers: [UsuarioService],
  exports: [
      UsuarioListComponent,
      UsuarioFormComponent
  ]
})
export class AuthModule { }
