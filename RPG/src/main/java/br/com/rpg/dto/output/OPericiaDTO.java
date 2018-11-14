package br.com.rpg.dto.output;

import lombok.*;

import java.util.Date;


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
    private Integer modificador;

    private Date created_at;
    private Date updated_at;

}
