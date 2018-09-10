import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  template: '<router-outlet></router-outlet>'
})
export class AventuraComponent {

  constructor(
    private router: Router,
    private route: ActivatedRoute
  ) { }
}