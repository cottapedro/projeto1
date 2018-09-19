package br.com.rpg.api;

import br.com.rpg.as.TesteAS;
import br.com.rpg.dto.TesteDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teste")
public class TesteAPI {

    @NonNull
    TesteAS testeAS;

    @GetMapping
    public List<TesteDTO> findAll() {
        return this.testeAS.findAll();
    }

    @GetMapping("/{id}")
    public TesteDTO findById(@PathVariable("id") Integer id) {
        return this.testeAS.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Integer id) {
        this.testeAS.deleteById(id);
    }

    @PostMapping
    public TesteDTO save(@RequestBody TesteDTO testeDTO) {
        return this.testeAS.save(testeDTO);
    }

    @PutMapping("/{id}")
    public TesteDTO update(@PathVariable("id") Integer id, @RequestBody TesteDTO testeDTO) {
        return this.testeAS.update(id, testeDTO);
    }
}
