package br.com.rpg.dto;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class HabilidadeRacaDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Integer tipoHabilidade;
    private Integer valor;
    private String skill;
    private RacaDTO raca;

}
