package br.com.rpg.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.rpg.domain.Habilidade;

public interface HabilidadeRepository extends JpaRepository<Habilidade, Integer> {

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM Habilidade u WHERE u.id = :id")
    public boolean existHabilidadeRaca(@Param("id") Integer id);

    @Query("SELECT u.created_at FROM Habilidade u WHERE u.id = :id")
    public Date dataCriacao(@Param("id") Integer id);
}
