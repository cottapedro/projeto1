package br.com.rpg.api;

import br.com.rpg.as.UsuarioAS;
import br.com.rpg.dto.IdDTO;
import br.com.rpg.dto.UsuarioDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioAPI {

    @NonNull
    UsuarioAS usuarioAS;

    @GetMapping
    public List<UsuarioDTO> findAll() {
        return this.usuarioAS.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioDTO findById(@PathVariable("id") Integer id) {
        return this.usuarioAS.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Integer id) {
        this.usuarioAS.deleteById(id);
    }

    @PostMapping
    public UsuarioDTO save(@RequestBody UsuarioDTO usuarioDTO) {
        return this.usuarioAS.save(usuarioDTO);
    }

    @PutMapping("/{id}")
    public UsuarioDTO update(@PathVariable("id") Integer id, @RequestBody UsuarioDTO usuarioDTO) {
        return this.usuarioAS.update(id, usuarioDTO);
    }
}
