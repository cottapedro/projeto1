package br.com.rpg.as;

import static br.com.rpg.comum.ValidacaoUtils.throwIf;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rpg.domain.Usuario;
import br.com.rpg.dto.input.IUsuarioDTO;
import br.com.rpg.dto.output.OUsuarioDTO;
import br.com.rpg.service.UsuarioService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioAS {

    @NonNull
    private UsuarioService usuarioService;
    @NonNull
    private ConverterMapper mapper;

    @Transactional(readOnly = true)
    public List<OUsuarioDTO> findAll(){
        List<Usuario> usuarios = this.usuarioService.findAll();
        return this.mapper.mapAsList(usuarios, OUsuarioDTO.class);
    }

    @Transactional(readOnly = true)
    public OUsuarioDTO findById(Integer id){
        Usuario usuario = this.usuarioService.findById(id);
        return mapper.map(usuario, OUsuarioDTO.class);
    }

    @Transactional
    public void deleteById(Integer id) {
        this.usuarioService.deleteById(id);
    }

    @Transactional
    public OUsuarioDTO save(IUsuarioDTO usuarioDTO){
        validarLogin(usuarioDTO.getLogin());
        Usuario usuario = this.mapper.map(usuarioDTO, Usuario.class);
        usuario = this.usuarioService.save(usuario);
        return this.mapper.map(usuario, OUsuarioDTO.class);
    }

    @Transactional
    public OUsuarioDTO update(Integer id, IUsuarioDTO usuarioDTO) {
        validarID(id);
        validarLogin(usuarioDTO.getLogin());
        Usuario usuario = this.mapper.map(usuarioDTO, Usuario.class);
        usuario.setId(id);
        usuario = this.usuarioService.save(usuario);
        return this.mapper.map(usuario, OUsuarioDTO.class);
    }

    private void validarID(Integer id) {
        throwIf(id, Objects::isNull, "ID Usuario can not be null");
        boolean existUsuario = this.usuarioService.existUsuario(id);
        throwIf(existUsuario, Boolean.FALSE::equals, "Usuario does not already exist");

    }
    private void validarLogin(String login) {
        throwIf(login, Objects::isNull, "Login can not be null");
        boolean existLogin = this.usuarioService.existLogin(login);
        throwIf(existLogin, Boolean.TRUE::equals, "Login does already exist");
    }
}
