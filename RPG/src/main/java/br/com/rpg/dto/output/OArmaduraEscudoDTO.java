package br.com.rpg.dto.output;

import java.util.Date;

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
public class OArmaduraEscudoDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Integer bonusCA;
    private Integer maximoDestreza;
    private Integer penalidade;
    private Integer categoria;
    private Integer peso;

    private Date created_at;
    private Date updated_at;

}
