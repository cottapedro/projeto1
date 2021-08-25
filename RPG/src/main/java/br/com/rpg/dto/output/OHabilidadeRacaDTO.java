package br.com.rpg.dto.output;

import java.util.Date;
import java.util.List;

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
public class OHabilidadeRacaDTO {

    private Integer id;
    private String nome;
    private ORacaDTO raca;
    private List<OHabilidadeDTO> habilidades;

    private Date created_at;
    private Date updated_at;

}
