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

import br.com.rpg.as.ArmaduraEscudoAS;
import br.com.rpg.dto.input.IArmaduraEscudoDTO;
import br.com.rpg.dto.output.OArmaduraEscudoDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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
