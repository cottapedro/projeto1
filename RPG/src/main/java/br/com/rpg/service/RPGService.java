package br.com.rpg.service;


import static br.com.rpg.comum.ValidacaoUtils.throwIf;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.rpg.domain.RPG;
import br.com.rpg.repository.RPGRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RPGService {

    @NonNull
    private RPGRepository rpgRepository;

    @Transactional(readOnly = true)
    public List<RPG> findAll(){
        return this.rpgRepository.findAll();
    }

    @Transactional(readOnly = true)
    public RPG findById(Integer id){
        return this.rpgRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Integer id){
        this.rpgRepository.deleteById(id);
    }

    @Transactional
    public RPG save(RPG rpg){
        this.validarRPG(rpg);
        return this.rpgRepository.save(this.preencheData(rpg));
    }

    @Transactional(readOnly = true)
    public boolean existRPG(Integer id) {
        throwIf(id, Objects::isNull, "ID RPG can not be null");
        return this.rpgRepository.existRPG(id);
    }

    private RPG preencheData(RPG rpg){
        if(rpg.getId() == null){
            rpg.setCreated_at(new Date());
        }
        else{
            rpg.setCreated_at(rpgRepository.dataCriacao(rpg.getId()));
        }
        rpg.setUpdated_at(new Date());
        return rpg;
    }

    private void validarRPG(RPG rpg){
        throwIf(rpg, Objects::isNull, "RPG can not be null");
    }
}
