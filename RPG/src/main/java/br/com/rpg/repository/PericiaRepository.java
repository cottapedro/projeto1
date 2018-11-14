package br.com.rpg.repository;

import br.com.rpg.domain.Pericia;
import br.com.rpg.domain.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface PericiaRepository extends JpaRepository<Pericia, Integer> {

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM Pericia u WHERE u.id = :id")
    public boolean existPericia(@Param("id") Integer id);

    @Query("SELECT u.created_at FROM Pericia u WHERE u.id = :id")
    public Date dataCriacao(@Param("id") Integer id);
}
