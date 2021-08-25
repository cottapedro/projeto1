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

import br.com.rpg.as.ArmaAS;
import br.com.rpg.dto.input.IArmaDTO;
import br.com.rpg.dto.output.OArmaDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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
