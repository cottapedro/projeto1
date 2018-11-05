package br.com.rpg.config;

import br.com.rpg.domain.Usuario;
import br.com.rpg.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException{
        Usuario usuario = usuarioRepository.findByLogin(login);

        if(usuario == null){
            throw  new UsernameNotFoundException("Usuario not found");
        }
        return (new User(usuario.getUsername(), usuario.getPassword(),usuario.isEnabled(),usuario.isAccountNonExpired(),usuario.isCredentialsNonExpired(),usuario.isAccountNonLocked(),usuario.getAuthorities()));
    }
}
