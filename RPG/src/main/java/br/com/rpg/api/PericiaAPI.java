package br.com.rpg.api;

import br.com.rpg.as.PericiaAS;
import br.com.rpg.as.RacaAS;
import br.com.rpg.dto.input.IPericiaDTO;
import br.com.rpg.dto.input.IRacaDTO;
import br.com.rpg.dto.output.OPericiaDTO;
import br.com.rpg.dto.output.ORacaDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pericia")
public class PericiaAPI {

    @NonNull
    PericiaAS periciaAS;

    @GetMapping
    public List<OPericiaDTO> findAll() {
        return this.periciaAS.findAll();
    }

    @GetMapping("/{id}")
    public OPericiaDTO findById(@PathVariable("id") Integer id) {
        return this.periciaAS.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Integer id) {
        this.periciaAS.deleteById(id);
    }

    @PostMapping
    public OPericiaDTO save(@RequestBody IPericiaDTO periciaDTO) {
        return this.periciaAS.save(periciaDTO);
    }

    @PutMapping("/{id}")
    public OPericiaDTO update(@PathVariable("id") Integer id, @RequestBody IPericiaDTO periciaDTO) {
        return this.periciaAS.update(id, periciaDTO);
    }
}
