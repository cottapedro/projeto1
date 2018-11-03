package br.com.rpg.api;

import br.com.rpg.as.HabilidadeRacaAS;
import br.com.rpg.dto.output.OHabilidadeRacaDTO;
import br.com.rpg.dto.input.IHabilidadeRacaDTO;
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
    public List<OHabilidadeRacaDTO> findAll() {
        return this.habilidadeRacaAS.findAll();
    }

    @GetMapping("/{id}")
    public OHabilidadeRacaDTO findById(@PathVariable("id") Integer id) {
        return this.habilidadeRacaAS.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Integer id) {
        this.habilidadeRacaAS.deleteById(id);
    }

    @PostMapping
    public OHabilidadeRacaDTO save(@RequestBody IHabilidadeRacaDTO iHabilidadeRacaDTO) {
        return this.habilidadeRacaAS.save(iHabilidadeRacaDTO);
    }

    @PutMapping("/{id}")
    public OHabilidadeRacaDTO update(@PathVariable("id") Integer id, @RequestBody IHabilidadeRacaDTO iHabilidadeRacaDTO) {
        return this.habilidadeRacaAS.update(id, iHabilidadeRacaDTO);
    }
}
