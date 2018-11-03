package br.com.rpg.dto.input;

import br.com.rpg.dto.output.ORacaDTO;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@ToString
public class IHabilidadeRacaDTO {

    private String nome;
    private String descricao;
    private Integer tipoHabilidade;
    private Integer valor;
    private String skill;
    private ORacaDTO raca;

}
