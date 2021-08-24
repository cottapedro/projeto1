package br.com.rpg.dto.output;

import java.util.Date;
import java.util.List;

import br.com.rpg.domain.Atributo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


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
    private List<Atributo> atributos;
    private ORacaDTO raca;

    private Date created_at;
    private Date updated_at;

}
