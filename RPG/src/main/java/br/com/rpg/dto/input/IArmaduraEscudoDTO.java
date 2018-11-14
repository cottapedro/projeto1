package br.com.rpg.dto.input;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@ToString
public class IArmaduraEscudoDTO {

    private String nome;
    private String descricao;
    private Integer bonusCA;
    private Integer maximoDestreza;
    private Integer penalidade;
    private Integer categoria;
    private Integer peso;


}
