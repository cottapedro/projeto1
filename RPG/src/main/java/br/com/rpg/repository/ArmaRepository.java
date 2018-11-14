package br.com.rpg.repository;

import br.com.rpg.domain.Arma;
import br.com.rpg.domain.Pericia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface ArmaRepository extends JpaRepository<Arma, Integer> {

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM Arma u WHERE u.id = :id")
    public boolean existArma(@Param("id") Integer id);

    @Query("SELECT u.created_at FROM Arma u WHERE u.id = :id")
    public Date dataCriacao(@Param("id") Integer id);
}
