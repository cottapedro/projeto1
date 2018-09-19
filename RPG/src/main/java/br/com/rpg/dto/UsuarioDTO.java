package br.com.rpg.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class UsuarioDTO {

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private Date created_at;
    private Date updated_at;

}
