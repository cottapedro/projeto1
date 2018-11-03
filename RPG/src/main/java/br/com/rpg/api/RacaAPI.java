package br.com.rpg.api;

import br.com.rpg.as.RacaAS;
import br.com.rpg.dto.IdDTO;
import br.com.rpg.dto.RacaDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/raca")
public class RacaAPI {

    @NonNull
    RacaAS racaAS;

    @GetMapping
    public List<RacaDTO> findAll() {
        return this.racaAS.findAll();
    }

    @GetMapping("/{id}")
    public RacaDTO findById(@PathVariable("id") Integer id) {
        return this.racaAS.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestBody IdDTO id) {
        this.racaAS.deleteById(id.getId());
    }

    @PostMapping
    public RacaDTO save(@RequestBody RacaDTO racaDTO) {
        return this.racaAS.save(racaDTO);
    }

    @PutMapping("/{id}")
    public RacaDTO update(@PathVariable("id") Integer id, @RequestBody RacaDTO racaDTO) {
        return this.racaAS.update(id, racaDTO);
    }
}
