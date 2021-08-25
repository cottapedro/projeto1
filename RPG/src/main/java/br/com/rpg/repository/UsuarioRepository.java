package br.com.rpg.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.rpg.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM Usuario u WHERE u.id = :id")
    public boolean existUsuario(@Param("id") Integer id);

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM Usuario u WHERE u.login = :login")
    public boolean existLogin(@Param("login") String login);

    @Query("SELECT u.created_at FROM Usuario u WHERE u.id = :id")
    public Date dataCriacao(@Param("id") Integer id);

    Usuario findByLogin(String login);
}
