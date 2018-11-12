import { Component } from '@angular/core';
import { Router } from '@angular/router';
// import {} from '';  - Stub de importación
import { Usuario } from 'src/app/model/usuario'; 
// Importando el servicio FeatureCollectionServiceService para conectarnos por Ajax
import { FeatureCollectionServiceService } from '../service/feature-collection-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  // Stub para crear variable en Ts, Angular
  // [nombre de variable] : [tipo de variable] = [Valor de la variable]
  
  featureCollection : Array<Object> = [];
  usuarioList : Array<Usuario> = [
    new Usuario("Ericson", "ehuamani", "Huamani"),
    new Usuario("Carlos", "ccastillo", "Castillo"),
    new Usuario("Juan", "jrodriguez", "Rodriguez"),
    new Usuario("Sara", "sdelcaripo", "Del Carpio")
  ]

  constructor(private router: Router, 
              private featureService: FeatureCollectionServiceService){}

  volver(){
    this.router.navigate(['login']);
  }

  getFeatureCollection(){
    this.featureService.getFeature().subscribe(
      // Stub para crear un observador
      (data: Array<object>) =>{
        this.featureCollection = data;
      });
  }

  mostrarMensaje( usuarioSelected: Usuario  ){
    alert( usuarioSelected.nombre + ", " + 
            usuarioSelected.nickname + ", " + 
            usuarioSelected.apellidos );
  }

}
