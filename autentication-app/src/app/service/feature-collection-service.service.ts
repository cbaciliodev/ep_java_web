import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FeatureCollectionServiceService {

  ENDPOINT_FC = 'http://52.40.250.179/sevenc/rest/evento';

  constructor( private httpClient: HttpClient ) { }

  getFeature(){
    // Comilla invertida ( alt + 96 )
    return this.httpClient.get(`${this.ENDPOINT_FC}/list_san/1/jhgjhgjgjhg`); 
  }
}
