package br.com.rpg.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rpg.as.AtributoAS;
import br.com.rpg.dto.input.IAtributoDTO;
import br.com.rpg.dto.output.OAtributoDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/atributo")
public class AtributoAPI {

    @NonNull
    AtributoAS atributoAS;

    @GetMapping
    public List<OAtributoDTO> findAll() {
        return this.atributoAS.findAll();
    }

    @GetMapping("/{id}")
    public OAtributoDTO findById(@PathVariable("id") Integer id) {
        return this.atributoAS.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Integer id) {
        this.atributoAS.deleteById(id);
    }

    @PostMapping
    public OAtributoDTO save(@RequestBody IAtributoDTO atributoDTO) {
        return this.atributoAS.save(atributoDTO);
    }

    @PutMapping("/{id}")
    public OAtributoDTO update(@PathVariable("id") Integer id, @RequestBody IAtributoDTO atributoDTO) {
        return this.atributoAS.update(id, atributoDTO);
    }
}
