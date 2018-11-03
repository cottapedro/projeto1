package br.com.rpg.as;

import br.com.rpg.domain.RPG;
import br.com.rpg.dto.RPGDTO;
import br.com.rpg.service.RPGService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static br.com.rpg.comum.ValidacaoUtils.throwIf;

@Service
@RequiredArgsConstructor
public class RPGAS {

    @NonNull
    private RPGService rpgService;
    @NonNull
    private ConverterMapper mapper;

    @Transactional(readOnly = true)
    public List<RPGDTO> findAll(){
        List<RPG> rpgs = this.rpgService.findAll();
        return this.mapper.mapAsList(rpgs, RPGDTO.class);
    }

    @Transactional(readOnly = true)
    public RPGDTO findById(Integer id){
        RPG rpg = this.rpgService.findById(id);
        return mapper.map(rpg, RPGDTO.class);
    }

    @Transactional
    public void deleteById(Integer id) {
        this.rpgService.deleteById(id);
    }

    @Transactional
    public RPGDTO save(RPGDTO rpgdto){
        RPG rpg = this.mapper.map(rpgdto, RPG.class);
        rpg = this.rpgService.save(rpg);
        return this.mapper.map(rpg, RPGDTO.class);
    }

    @Transactional
    public RPGDTO update(Integer id, RPGDTO rpgDTO) {
        throwIf(id, Objects::isNull, "ID RPG can not be null");
        boolean existRPG = this.rpgService.existRPG(id);
        throwIf(existRPG, Boolean.FALSE::equals, "RPG does not already exist");
        rpgDTO.setId(id);
        return this.save(rpgDTO);
    }
}
