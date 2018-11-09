import { Component } from '@angular/core';
import { Router } from '@angular/router';
// import {} from '';  - Stub de importación
import { Usuario } from 'src/app/model/usuario'; 

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  // Stub para crear variable en Ts, Angular
  // [nombre de variable] : [tipo de variable] = [Valor de la variable]
  
  usuarioList : Array<Usuario> = [
    new Usuario("Ericson", "ehuamani", "Huamani"),
    new Usuario("Carlos", "ccastillo", "Castillo"),
    new Usuario("Juan", "jrodriguez", "Rodriguez"),
    new Usuario("Sara", "sdelcaripo", "Del Carpio")
  ]

  constructor(private router: Router){}

  volver(){
    this.router.navigate(['login']);
  }

  mostrarMensaje( usuarioSelected: Usuario  ){
    alert( usuarioSelected.nombre + ", " + 
            usuarioSelected.nickname + ", " + 
            usuarioSelected.apellidos );
  }

}
