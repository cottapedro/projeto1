package br.com.rpg.api;

import br.com.rpg.as.HabilidadeRacaAS;
import br.com.rpg.dto.IdDTO;
import br.com.rpg.dto.HabilidadeRacaDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/habilidade-raca")
public class HabilidadeRacaAPI {

    @NonNull
    HabilidadeRacaAS habilidadeRacaAS;

    @GetMapping
    public List<HabilidadeRacaDTO> findAll() {
        return this.habilidadeRacaAS.findAll();
    }

    @GetMapping("/{id}")
    public HabilidadeRacaDTO findById(@PathVariable("id") Integer id) {
        return this.habilidadeRacaAS.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestBody IdDTO id) {
        this.habilidadeRacaAS.deleteById(id.getId());
    }

    @PostMapping
    public HabilidadeRacaDTO save(@RequestBody HabilidadeRacaDTO habilidadeRacaDTO) {
        return this.habilidadeRacaAS.save(habilidadeRacaDTO);
    }

    @PutMapping("/{id}")
    public HabilidadeRacaDTO update(@PathVariable("id") Integer id, @RequestBody HabilidadeRacaDTO habilidadeRacaDTO) {
        return this.habilidadeRacaAS.update(id, habilidadeRacaDTO);
    }
}
