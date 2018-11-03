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
public class OUsuarioDTO {

    private Integer id;
    private String login;
    private String nome;
    private String email;

    private Date created_at;
    private Date updated_at;
}
