package br.com.rpg.api;

import br.com.rpg.as.UsuarioAS;
import br.com.rpg.dto.input.IUsuarioDTO;
import br.com.rpg.dto.output.OUsuarioDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = { "http://localhost:4200" }, maxAge = 3000)
@RequestMapping("/usuario")
public class UsuarioAPI {

    @NonNull
    UsuarioAS usuarioAS;

    @GetMapping
    public List<OUsuarioDTO> findAll() {
        return this.usuarioAS.findAll();
    }

    @GetMapping("/{id}")
    public OUsuarioDTO findById(@PathVariable("id") Integer id) {
        return this.usuarioAS.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Integer id) {
        this.usuarioAS.deleteById(id);
    }

    @PostMapping
    public OUsuarioDTO save(@RequestBody IUsuarioDTO usuarioDTO) {
        return this.usuarioAS.save(usuarioDTO);
    }

    @PutMapping("/{id}")
    public OUsuarioDTO update(@PathVariable("id") Integer id, @RequestBody IUsuarioDTO usuarioDTO) {
        return this.usuarioAS.update(id, usuarioDTO);
    }
}
