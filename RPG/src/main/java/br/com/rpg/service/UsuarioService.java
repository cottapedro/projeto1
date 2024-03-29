package br.com.rpg.service;


import static br.com.rpg.comum.ValidacaoUtils.throwIf;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.rpg.domain.Usuario;
import br.com.rpg.repository.UsuarioRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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
        this.codificarSenha(usuario);
        return this.usuarioRepository.save(this.preencheData(usuario));
    }

    @Transactional(readOnly = true)
    public boolean existUsuario(Integer id) {
        throwIf(id, Objects::isNull, "ID Usuario can not be null");
        return this.usuarioRepository.existUsuario(id);
    }

    @Transactional(readOnly = true)
    public boolean existLogin(String login) {
        throwIf(login, Objects::isNull, "Login can not be null");
        return this.usuarioRepository.existLogin(login);
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

    private Usuario codificarSenha(Usuario usuario){
        String senha = usuario.getSenha();
        usuario.setSenha(new BCryptPasswordEncoder().encode(senha));
        return usuario;
    }

    private void validarUsuario(Usuario usuario){
        throwIf(usuario, Objects::isNull, "Usuario can not be null");
    }
}
