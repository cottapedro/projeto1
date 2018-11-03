package br.com.rpg.dto.input;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@ToString
public class IRacaDTO {

    private String nome;
    private String descricao;
    private IRPGDTO rpg;

}
