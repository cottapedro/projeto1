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
public class OArmaDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Integer dano;
    private String distancia;
    private Integer peso;
    private Integer qtdDano;
    private Integer ameaca;
    private Integer critico;

    private Date created_at;
    private Date updated_at;

}
