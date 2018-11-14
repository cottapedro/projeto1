import { Raca } from './raca';

export interface HabilidadesRaca {
    id?: number;
    nome: string;
    tipoHabilidade: string;
    valor: number;
    skill: string;
    raca: Raca;
    descricao: string;
}