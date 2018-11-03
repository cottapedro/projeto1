package br.com.rpg.service;


import br.com.rpg.domain.HabilidadeRaca;
import br.com.rpg.repository.HabilidadeRacaRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import static br.com.rpg.comum.ValidacaoUtils.throwIf;

@Component
@RequiredArgsConstructor
public class HabilidadeRacaService {

    @NonNull
    private HabilidadeRacaRepository habilidadeRacaRepository;

    @Transactional(readOnly = true)
    public List<HabilidadeRaca> findAll(){
        return this.habilidadeRacaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public HabilidadeRaca findById(Integer id){
        return this.habilidadeRacaRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Integer id){
        this.habilidadeRacaRepository.deleteById(id);
    }

    @Transactional
    public HabilidadeRaca save(HabilidadeRaca habilidadeRaca){
        this.validarHabilidadeRaca(habilidadeRaca);
        return this.habilidadeRacaRepository.save(this.preencheData(habilidadeRaca));
    }

    @Transactional(readOnly = true)
    public boolean existHabilidadeRaca(Integer id) {
        throwIf(id, Objects::isNull, "ID HabilidadeRaca can not be null");
        return this.habilidadeRacaRepository.existHabilidadeRaca(id);
    }

    private HabilidadeRaca preencheData(HabilidadeRaca habilidadeRaca){
        if(habilidadeRaca.getId() == null){
            habilidadeRaca.setCreated_at(new Date());
        }
        else{
            habilidadeRaca.setCreated_at(habilidadeRacaRepository.dataCriacao(habilidadeRaca.getId()));
        }
        habilidadeRaca.setUpdated_at(new Date());
        return habilidadeRaca;
    }

    private void validarHabilidadeRaca(HabilidadeRaca habilidadeRaca){
        throwIf(habilidadeRaca, Objects::isNull, "HabilidadeRaca can not be null");
    }
}
