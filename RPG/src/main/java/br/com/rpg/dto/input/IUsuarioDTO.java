package br.com.rpg.dto.input;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@ToString
public class IUsuarioDTO {

    private String login;
    private String nome;
    private String email;
    private String senha;

}
