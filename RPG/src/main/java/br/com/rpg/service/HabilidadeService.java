package br.com.rpg.service;


import static br.com.rpg.comum.ValidacaoUtils.throwIf;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.rpg.domain.Habilidade;
import br.com.rpg.repository.HabilidadeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HabilidadeService {

    @NonNull
    private HabilidadeRepository habilidadeRepository;

    @Transactional(readOnly = true)
    public List<Habilidade> findAll(){
        return this.habilidadeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Habilidade findById(Integer id){
        return this.habilidadeRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Integer id){
        this.habilidadeRepository.deleteById(id);
    }

    @Transactional
    public Habilidade save(Habilidade habilidade){
        this.validarHabilidadeRaca(habilidade);
        return this.habilidadeRepository.save(this.preencheData(habilidade));
    }

    @Transactional(readOnly = true)
    public boolean existHabilidadeRaca(Integer id) {
        throwIf(id, Objects::isNull, "ID Habilidade can not be null");
        return this.habilidadeRepository.existHabilidadeRaca(id);
    }

    private Habilidade preencheData(Habilidade habilidade){
        if(habilidade.getId() == null){
            habilidade.setCreated_at(new Date());
        }
        else{
            habilidade.setCreated_at(habilidadeRepository.dataCriacao(habilidade.getId()));
        }
        habilidade.setUpdated_at(new Date());
        return habilidade;
    }

    private void validarHabilidadeRaca(Habilidade habilidade){
        throwIf(habilidade, Objects::isNull, "Habilidade can not be null");
    }
}
