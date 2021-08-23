package br.com.rpg.dto.input;

import lombok.*;


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
    private String modificador;

}
