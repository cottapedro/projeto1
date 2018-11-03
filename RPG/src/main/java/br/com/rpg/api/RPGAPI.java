package br.com.rpg.api;

import br.com.rpg.as.RPGAS;
import br.com.rpg.dto.IdDTO;
import br.com.rpg.dto.RPGDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rpg")
public class RPGAPI {

    @NonNull
    RPGAS rpgAS;

    @GetMapping
    public List<RPGDTO> findAll() {
        return this.rpgAS.findAll();
    }

    @GetMapping("/{id}")
    public RPGDTO findById(@PathVariable("id") Integer id) {
        return this.rpgAS.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestBody IdDTO id) {
        this.rpgAS.deleteById(id.getId());
    }

    @PostMapping
    public RPGDTO save(@RequestBody RPGDTO rpgDTO) {
        return this.rpgAS.save(rpgDTO);
    }

    @PutMapping("/{id}")
    public RPGDTO update(@PathVariable("id") Integer id, @RequestBody RPGDTO rpgDTO) {
        return this.rpgAS.update(id, rpgDTO);
    }
}
