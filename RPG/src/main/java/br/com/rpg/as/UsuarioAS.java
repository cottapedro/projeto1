package br.com.rpg.as;

import br.com.rpg.domain.Usuario;
import br.com.rpg.dto.UsuarioDTO;
import br.com.rpg.service.UsuarioService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static br.com.rpg.comum.ValidacaoUtils.throwIf;

@Service
@RequiredArgsConstructor
public class UsuarioAS {

    @NonNull
    private UsuarioService usuarioService;
    @NonNull
    private ConverterMapper mapper;

    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll(){
        List<Usuario> usuarios = this.usuarioService.findAll();
        return this.mapper.mapAsList(usuarios, UsuarioDTO.class);
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findById(Integer id){
        Usuario usuario = this.usuarioService.findById(id);
        return mapper.map(usuario, UsuarioDTO.class);
    }

    @Transactional
    public void deleteById(Integer id) {
        this.usuarioService.deleteById(id);
    }

    @Transactional
    public UsuarioDTO save(UsuarioDTO usuarioDTO){
        Usuario usuario = this.mapper.map(usuarioDTO, Usuario.class);
        usuario = this.usuarioService.save(usuario);
        return this.mapper.map(usuario, UsuarioDTO.class);
    }

    @Transactional
    public UsuarioDTO update(Integer id, UsuarioDTO usuarioDTO) {
        throwIf(id, Objects::isNull, "ID Usuario can not be null");
        boolean existUsuario = this.usuarioService.existUsuario(id);
        throwIf(existUsuario, Boolean.FALSE::equals, "Usuario does not already exist");
        usuarioDTO.setId(id);
        return this.save(usuarioDTO);
    }
}
