package br.com.rpg.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.rpg.domain.Atributo;


public interface AtributoRepository extends JpaRepository<Atributo, Integer> {

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM Atributo u WHERE u.id = :id")
    public boolean existAtributo(@Param("id") Integer id);

    @Query("SELECT u.created_at FROM Atributo u WHERE u.id = :id")
    public Date dataCriacao(@Param("id") Integer id);
}
