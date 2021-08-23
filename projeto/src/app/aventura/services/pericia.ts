import { Atributo } from "./atributo";

export interface Pericia {
    id?: number;
    nome: string;
    atributo: Atributo;
    descricao: string;
}