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

import br.com.rpg.as.HabilidadeAS;
import br.com.rpg.dto.input.IHabilidadeDTO;
import br.com.rpg.dto.output.OHabilidadeDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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
