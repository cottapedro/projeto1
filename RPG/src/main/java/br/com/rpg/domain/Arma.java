package br.com.rpg.domain;


import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DynamicUpdate
@SelectBeforeUpdate
@Table(name="arma")
public class Arma extends BaseEntity<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name="descricao")
    private String descricao;

    @Column(name = "dano")
    private Integer dano;

    @Column(name = "distancia")
    private String distancia;

    @Column(name = "peso")
    private Integer peso;

    @Column(name = "qtd_dano")
    private Integer qtdDano;

    @Column(name = "ameaca")
    private Integer ameaca;

    @Column(name = "critico")
    private Integer critico;


    @Column(name="created_at", nullable = false)
    private Date created_at;

    @Column(name="updated_at", nullable = false)
    private Date updated_at;

}