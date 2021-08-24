package br.com.rpg.dto.output;

import java.util.Date;

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
@EqualsAndHashCode(of = "id")
@ToString
public class OPericiaDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Boolean penalidadeArmadura;
    private Boolean somenteTreinada;
    private Atributo atributo;

    private Date created_at;
    private Date updated_at;

}
