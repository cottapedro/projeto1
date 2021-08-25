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

import br.com.rpg.as.PericiaAS;
import br.com.rpg.dto.input.IPericiaDTO;
import br.com.rpg.dto.output.OPericiaDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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
