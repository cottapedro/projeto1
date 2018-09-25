package br.com.rpg.service;


import br.com.rpg.domain.Usuario;
import br.com.rpg.repository.UsuarioRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import static br.com.rpg.comum.ValidacaoUtils.throwIf;

@Component
@RequiredArgsConstructor
public class UsuarioService {

    @NonNull
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public List<Usuario> findAll(){
        return this.usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario findById(Integer id){
        return this.usuarioRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Integer id){
        this.usuarioRepository.deleteById(id);
    }

    @Transactional
    public Usuario save(Usuario usuario){
        this.validarUsuario(usuario);
        return this.usuarioRepository.save(this.preencheData(usuario));
    }

    @Transactional(readOnly = true)
    public boolean existUsuario(Integer id) {
        throwIf(id, Objects::isNull, "ID Usuario can not be null");
        return this.usuarioRepository.existUsuario(id);
    }

    private Usuario preencheData(Usuario usuario){
        if(usuario.getId() == null){
            usuario.setCreated_at(new Date());
        }
        else{
            usuario.setCreated_at(usuarioRepository.dataCriacao(usuario.getId()));
        }
        usuario.setUpdated_at(new Date());
        return usuario;
    }

    private void validarUsuario(Usuario usuario){
        throwIf(usuario, Objects::isNull, "Usuario can not be null");
    }
}
