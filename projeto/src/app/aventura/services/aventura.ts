import { Usuario } from "src/app/auth/services/usuario";

export interface Aventura {
    id?: number;
    tipo: string;
    membros: Usuario[];
    mestre: Usuario;
    dataInicio: number;
}
