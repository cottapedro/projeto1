package br.com.rpg.dto.input;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@ToString
public class IAtributoDTO {

	private Integer id;
    private String nome;
    private String sigla;

}
