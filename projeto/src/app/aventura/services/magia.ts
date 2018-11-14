export interface Magia {
    id?: number;
    nome: string;
    descricao: string;
    categoria: string; //enum arcana, divina
    nivel: number;
    alcance?: number;
    efeito:any;
}