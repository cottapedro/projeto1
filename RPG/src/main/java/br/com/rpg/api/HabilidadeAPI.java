package br.com.rpg.api;

import br.com.rpg.as.HabilidadeAS;
import br.com.rpg.dto.output.OHabilidadeDTO;
import br.com.rpg.dto.input.IHabilidadeDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/habilidade")
public class HabilidadeAPI {

    @NonNull
    HabilidadeAS habilidadeAS;

    @GetMapping
    public List<OHabilidadeDTO> findAll() {
        return this.habilidadeAS.findAll();
    }

    @GetMapping("/{id}")
    public OHabilidadeDTO findById(@PathVariable("id") Integer id) {
        return this.habilidadeAS.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Integer id) {
        this.habilidadeAS.deleteById(id);
    }

    @PostMapping
    public OHabilidadeDTO save(@RequestBody IHabilidadeDTO iHabilidadeRacaDTO) {
        return this.habilidadeAS.save(iHabilidadeRacaDTO);
    }

    @PutMapping("/{id}")
    public OHabilidadeDTO update(@PathVariable("id") Integer id, @RequestBody IHabilidadeDTO iHabilidadeRacaDTO) {
        return this.habilidadeAS.update(id, iHabilidadeRacaDTO);
    }
}
