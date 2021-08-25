import { Raca } from './raca';
import { Habilidade } from './habilidade';

export interface HabilidadesRaca {
    id?: number;
    nome: string;
    raca: Raca;
    habilidades: Habilidade[]
}