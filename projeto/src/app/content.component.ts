import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router} from "@angular/router";
// import {Subscription} from "rxjs";
// import {AuthService} from "app/auth/services";
// import {UsuarioLogado} from "./auth/services/usuario-logado";
// import {StringUtil} from "app/utils/string-util";
// import {GrupoTela, MenuService, Tela} from "app/menu.service";
// import {LoadingStatusService} from "./loading-status.service";
// import { MdlLayoutDrawerComponent } from '@angular-mdl/core';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html'
})
export class ContentComponent implements OnInit, OnDestroy {

  //private routerEvts:Subscription;

  constructor(
     private router: Router,
     private route: ActivatedRoute,
    // private loadingStatus: LoadingStatusService,
    // private authService: AuthService,
    // private menuService: MenuService 
) {}

  ngOnInit(){
    //window['componentHandler'].upgradeAllRegistered();
  }

  navegarPara(destino:string){
    this.router.navigate([`app/${destino}`]);
  }

  ngOnDestroy():void{
    //this.routerEvts.unsubscribe();
  }
}
