import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'auth-access-denied',
  template: `
    <div class="container" id="acessoNegado">
      <h1><i class="material-icons">error</i>  <span>Ops...</span></h1>
      <h3>Você não tem permissão para acessar a página solicitada.</h3>
      <p>Para mais informações, contate o administrador do sistema</p>
    </div>
  `
})
export class AccessDeniedComponent{

}
