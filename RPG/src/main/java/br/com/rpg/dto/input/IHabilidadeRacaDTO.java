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
public class IHabilidadeRacaDTO {

    private String nome;
    private IRacaDTO raca;
    private Integer valor;
    //private List<IHabilidadeDTO> habilidades;

}
