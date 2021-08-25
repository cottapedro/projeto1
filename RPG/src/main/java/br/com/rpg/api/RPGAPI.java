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

import br.com.rpg.as.RPGAS;
import br.com.rpg.dto.input.IRPGDTO;
import br.com.rpg.dto.output.ORPGDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rpg")
public class RPGAPI {

    @NonNull
    RPGAS rpgAS;

    @GetMapping
    public List<ORPGDTO> findAll() {
        return this.rpgAS.findAll();
    }

    @GetMapping("/{id}")
    public ORPGDTO findById(@PathVariable("id") Integer id) {
        return this.rpgAS.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Integer id) {
        this.rpgAS.deleteById(id);
    }

    @PostMapping
    public ORPGDTO save(@RequestBody IRPGDTO rpgDTO) {
        return this.rpgAS.save(rpgDTO);
    }

    @PutMapping("/{id}")
    public ORPGDTO update(@PathVariable("id") Integer id, @RequestBody IRPGDTO rpgDTO) {
        return this.rpgAS.update(id, rpgDTO);
    }
}
