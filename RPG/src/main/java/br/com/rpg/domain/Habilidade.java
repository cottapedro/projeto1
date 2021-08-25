package br.com.rpg.domain;


import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DynamicUpdate
@SelectBeforeUpdate
@Table(name="habilidade")
public class Habilidade extends BaseEntity<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="descricao")
    private String descricao;

    @Column(name="tipo_habilidade")
    private Integer tipoHabilidade;

    @Column(name="valor")
    private Integer valor;

    @Column(name="skill")
    private String skill;

    @ManyToOne
    @JoinColumn(name = "habilidade_raca_id")
    private HabilidadeRaca habilidadeRaca;
    
    @ManyToMany
    @JoinTable(
	    name = "atributos_habilidade",
	    joinColumns = @JoinColumn(name = "habilidade_raca_id", referencedColumnName = "id"),
	    inverseJoinColumns = @JoinColumn(name = "atributo_id", referencedColumnName = "id"))
    private List<Atributo> atributos;

    @Column(name="created_at", nullable = false)
    private Date created_at;

    @Column(name="updated_at", nullable = false)
    private Date updated_at;

}