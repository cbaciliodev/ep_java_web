import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from "@angular/forms";
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor( private formBuilder: FormBuilder, private router: Router ) { }

  onSubmit(){
    if( this.loginForm.controls.usuario.value=='admin' ){
      this.router.navigate(['main']);
    }else{
      alert("Usuario incorrecto");
    }
  }

  cancelar(){
    this.router.navigate(['inicio']);
  }

  ngOnInit() {

    this.loginForm = this.formBuilder.group({
      usuario:[''],
      clave:['']
    });

  }

}
