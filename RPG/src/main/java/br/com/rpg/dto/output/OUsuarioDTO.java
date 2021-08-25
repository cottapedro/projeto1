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
public class OUsuarioDTO {

    private Integer id;
    private String login;
    private String nome;
    private String email;

    private Date created_at;
    private Date updated_at;
}
