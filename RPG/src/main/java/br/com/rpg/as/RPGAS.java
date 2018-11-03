package br.com.rpg.as;

import br.com.rpg.domain.RPG;
import br.com.rpg.dto.input.IRPGDTO;
import br.com.rpg.dto.output.ORPGDTO;
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
    public List<ORPGDTO> findAll(){
        List<RPG> rpgs = this.rpgService.findAll();
        return this.mapper.mapAsList(rpgs, ORPGDTO.class);
    }

    @Transactional(readOnly = true)
    public ORPGDTO findById(Integer id){
        RPG rpg = this.rpgService.findById(id);
        return mapper.map(rpg, ORPGDTO.class);
    }

    @Transactional
    public void deleteById(Integer id) {
        this.rpgService.deleteById(id);
    }

    @Transactional
    public ORPGDTO save(IRPGDTO rpgDTO){
        RPG rpg = this.mapper.map(rpgDTO, RPG.class);
        rpg = this.rpgService.save(rpg);
        return this.mapper.map(rpg, ORPGDTO.class);
    }

    @Transactional
    public ORPGDTO update(Integer id, IRPGDTO rpgDTO) {
        validar(id);
        RPG rpg = this.mapper.map(rpgDTO, RPG.class);
        rpg.setId(id);
        rpg = this.rpgService.save(rpg);
        return this.mapper.map(rpg, ORPGDTO.class);
    }

    private void validar(Integer id) {
        throwIf(id, Objects::isNull, "ID RPG can not be null");
        boolean existRPG = this.rpgService.existRPG(id);
        throwIf(existRPG, Boolean.FALSE::equals, "RPG does not already exist");
    }
}
