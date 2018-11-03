package br.com.rpg.repository;

import br.com.rpg.domain.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface RacaRepository extends JpaRepository<Raca, Integer> {

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM Raca u WHERE u.id = :id")
    public boolean existRaca(@Param("id") Integer id);

    @Query("SELECT u.created_at FROM Raca u WHERE u.id = :id")
    public Date dataCriacao(@Param("id") Integer id);
}
