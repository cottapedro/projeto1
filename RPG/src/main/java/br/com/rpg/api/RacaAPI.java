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

import br.com.rpg.as.RacaAS;
import br.com.rpg.dto.input.IRacaDTO;
import br.com.rpg.dto.output.ORacaDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("**/raca")
public class RacaAPI {

    @NonNull
    RacaAS racaAS;

    @GetMapping
    public List<ORacaDTO> findAll() {
        return this.racaAS.findAll();
    }

    @GetMapping("/{id}")
    public ORacaDTO findById(@PathVariable("id") Integer id) {
        return this.racaAS.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Integer id) {
        this.racaAS.deleteById(id);
    }

    @PostMapping
    public ORacaDTO save(@RequestBody IRacaDTO racaDTO) {
        return this.racaAS.save(racaDTO);
    }

    @PutMapping("/{id}")
    public ORacaDTO update(@PathVariable("id") Integer id, @RequestBody IRacaDTO racaDTO) {
        return this.racaAS.update(id, racaDTO);
    }
}
