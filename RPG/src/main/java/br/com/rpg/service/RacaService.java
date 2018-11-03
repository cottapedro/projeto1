package br.com.rpg.service;


import br.com.rpg.domain.Raca;
import br.com.rpg.repository.RacaRepository;
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
public class RacaService {

    @NonNull
    private RacaRepository racaRepository;

    @Transactional(readOnly = true)
    public List<Raca> findAll(){
        return this.racaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Raca findById(Integer id){
        return this.racaRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Integer id){
        this.racaRepository.deleteById(id);
    }

    @Transactional
    public Raca save(Raca raca){
        this.validarRaca(raca);
        return this.racaRepository.save(this.preencheData(raca));
    }

    @Transactional(readOnly = true)
    public boolean existRaca(Integer id) {
        throwIf(id, Objects::isNull, "ID Raca can not be null");
        return this.racaRepository.existRaca(id);
    }

    private Raca preencheData(Raca raca){
        if(raca.getId() == null){
            raca.setCreated_at(new Date());
        }
        else{
            raca.setCreated_at(racaRepository.dataCriacao(raca.getId()));
        }
        raca.setUpdated_at(new Date());
        return raca;
    }

    private void validarRaca(Raca raca){
        throwIf(raca, Objects::isNull, "Raca can not be null");
    }
}
