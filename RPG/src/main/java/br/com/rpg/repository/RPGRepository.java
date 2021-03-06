package br.com.rpg.repository;

import br.com.rpg.domain.RPG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface RPGRepository extends JpaRepository<RPG, Integer> {

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM RPG u WHERE u.id = :id")
    public boolean existRPG(@Param("id") Integer id);

    @Query("SELECT u.created_at FROM RPG u WHERE u.id = :id")
    public Date dataCriacao(@Param("id") Integer id);
}
