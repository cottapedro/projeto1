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

import br.com.rpg.as.HabilidadeRacaAS;
import br.com.rpg.dto.input.IHabilidadeRacaDTO;
import br.com.rpg.dto.output.OHabilidadeRacaDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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
