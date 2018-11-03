package br.com.rpg.dto;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class RPGDTO {

    private Integer id;
    private String nome;
    private String descricao;

}
