
export class Usuario {

    nombre : string;
    nickname: string;
    apellidos: string;

    constructor(    nombre: string,
                    nickname: string,
                    apellidos: string ){
        this.nickname = nickname;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

}
