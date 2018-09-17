package br.com.rpg.repository;

import br.com.rpg.domain.Teste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TesteRepository extends JpaRepository<Teste, Integer> {

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM Teste j WHERE j.id = :id")
    public boolean existTeste(@Param("id") Integer id);
}
