package br.com.rpg.dto.output;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class OHabilidadeRacaDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Integer tipoHabilidade;
    private Integer valor;
    private String skill;
    private ORacaDTO raca;

    private Date created_at;
    private Date updated_at;

}
