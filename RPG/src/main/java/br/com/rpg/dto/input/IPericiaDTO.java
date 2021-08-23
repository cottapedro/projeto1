package br.com.rpg.dto.input;

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
@EqualsAndHashCode()
@ToString
public class IPericiaDTO {

	private Integer id;
    private String nome;
    private String descricao;
    private Atributo atributo;

}
