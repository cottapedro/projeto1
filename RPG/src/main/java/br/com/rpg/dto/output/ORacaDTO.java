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
public class ORacaDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private ORPGDTO rpg;

    private Date created_at;
    private Date updated_at;

}
