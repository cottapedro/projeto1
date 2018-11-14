package br.com.rpg.api;

import br.com.rpg.as.ArmaduraEscudoAS;
import br.com.rpg.as.RacaAS;
import br.com.rpg.domain.ArmaduraEscudo;
import br.com.rpg.dto.input.IArmaduraEscudoDTO;
import br.com.rpg.dto.input.IRacaDTO;
import br.com.rpg.dto.output.OArmaduraEscudoDTO;
import br.com.rpg.dto.output.ORacaDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/armadura-escudo")
public class ArmaduraEscudoAPI {

    @NonNull
    ArmaduraEscudoAS armaduraEscudoAS;

    @GetMapping
    public List<OArmaduraEscudoDTO> findAll() {
        return this.armaduraEscudoAS.findAll();
    }

    @GetMapping("/{id}")
    public OArmaduraEscudoDTO findById(@PathVariable("id") Integer id) {
        return this.armaduraEscudoAS.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Integer id) {
        this.armaduraEscudoAS.deleteById(id);
    }

    @PostMapping
    public OArmaduraEscudoDTO save(@RequestBody IArmaduraEscudoDTO armaduraEscudoDTO) {
        return this.armaduraEscudoAS.save(armaduraEscudoDTO);
    }

    @PutMapping("/{id}")
    public OArmaduraEscudoDTO update(@PathVariable("id") Integer id, @RequestBody IArmaduraEscudoDTO armaduraEscudoDTO) {
        return this.armaduraEscudoAS.update(id, armaduraEscudoDTO);
    }
}
