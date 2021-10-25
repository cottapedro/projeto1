import { Usuario } from "src/app/auth/services/usuario";

export interface Role {
    id?: number;
    nome: string;
    descricao: string;
    jogadores: Usuario[];
    mestre: Usuario;
}