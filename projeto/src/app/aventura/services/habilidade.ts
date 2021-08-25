import { HabilidadesRaca } from "./habilidadeRaca";

export interface Habilidade {
    id?: number;
    tipoHabilidade: any;
    valor: number;
    skill: string;
    descricao: string;
    habilidadeRaca: HabilidadesRaca 
}