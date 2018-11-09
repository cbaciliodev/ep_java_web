import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './inicio/inicio.component';
import { LoginComponent } from './login/login.component';
import { AppComponent } from './main/app.component';

// Crea una constante en JScript
const routes : Routes = [
    // Estructura JSon
    { path: 'inicio', component: InicioComponent },
    { path: 'login', component: LoginComponent },
    { path: 'main', component: AppComponent },
    { path: '', component: InicioComponent }
];

// Exponiendo el route a la aplicación
export const routing = RouterModule.forRoot( routes );
