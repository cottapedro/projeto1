package br.com.rpg.dto.input;

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
