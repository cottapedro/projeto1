package br.com.rpg.service;


import static br.com.rpg.comum.ValidacaoUtils.throwIf;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.rpg.domain.Atributo;
import br.com.rpg.repository.AtributoRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AtributoService {

    @NonNull
    private AtributoRepository atributoRepository;

    @Transactional(readOnly = true)
    public List<Atributo> findAll(){
        return this.atributoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Atributo findById(Integer id){
        return this.atributoRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Integer id){
        this.atributoRepository.deleteById(id);
    }

    @Transactional
    public Atributo save(Atributo atributo){
        this.validarAtributo(atributo);
        return this.atributoRepository.save(this.preencheData(atributo));
    }

    @Transactional(readOnly = true)
    public boolean existAtributo(Integer id) {
        throwIf(id, Objects::isNull, "ID Pericia can not be null");
        return this.atributoRepository.existAtributo(id);
    }

    private Atributo preencheData(Atributo atributo){
        if(atributo.getId() == null){
        	atributo.setCreated_at(new Date());
        }
        else{
        	atributo.setCreated_at(atributoRepository.dataCriacao(atributo.getId()));
        }
        atributo.setUpdated_at(new Date());
        return atributo;
    }

    private void validarAtributo(Atributo atributo){
        throwIf(atributo, Objects::isNull, "Pericia can not be null");
    }
}
