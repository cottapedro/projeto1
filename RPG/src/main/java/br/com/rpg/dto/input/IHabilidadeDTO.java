package br.com.rpg.dto.input;

import java.util.List;

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
@EqualsAndHashCode()
@ToString
public class IHabilidadeDTO {

    private String descricao;
    private Integer tipoHabilidade;
    private Integer valor;
    private String skill;
    private List<IAtributoDTO> atributos;

}
