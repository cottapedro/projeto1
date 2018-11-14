package br.com.rpg.dto.input;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@ToString
public class IArmaDTO {

    private String nome;
    private String descricao;
    private Integer dano;
    private String distancia;
    private Integer peso;
    private Integer qtdDano;
    private Integer ameaca;
    private Integer critico;

}
