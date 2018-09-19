package br.com.rpg.repository;

import br.com.rpg.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM Usuario j WHERE j.id = :id")
    public boolean existUsuario(@Param("id") Integer id);
}
