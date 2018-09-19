package br.com.rpg.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class TesteDTO {

    private Integer id;
    private String nome;
    private String email;
}
