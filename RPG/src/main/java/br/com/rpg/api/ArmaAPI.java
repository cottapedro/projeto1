package br.com.rpg.api;

import br.com.rpg.as.ArmaAS;
import br.com.rpg.dto.input.IArmaDTO;
import br.com.rpg.dto.output.OArmaDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/arma")
public class ArmaAPI {

    @NonNull
    ArmaAS armaAS;

    @GetMapping
    public List<OArmaDTO> findAll() {
        return this.armaAS.findAll();
    }

    @GetMapping("/{id}")
    public OArmaDTO findById(@PathVariable("id") Integer id) {
        return this.armaAS.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Integer id) {
        this.armaAS.deleteById(id);
    }

    @PostMapping
    public OArmaDTO save(@RequestBody IArmaDTO armaDTO) {
        return this.armaAS.save(armaDTO);
    }

    @PutMapping("/{id}")
    public OArmaDTO update(@PathVariable("id") Integer id, @RequestBody IArmaDTO armaDTO) {
        return this.armaAS.update(id, armaDTO);
    }
}
