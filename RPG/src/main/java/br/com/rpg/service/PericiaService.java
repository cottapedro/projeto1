package br.com.rpg.service;


import br.com.rpg.domain.Pericia;
import br.com.rpg.repository.PericiaRepository;
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
public class PericiaService {

    @NonNull
    private PericiaRepository periciaRepository;

    @Transactional(readOnly = true)
    public List<Pericia> findAll(){
        return this.periciaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Pericia findById(Integer id){
        return this.periciaRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Integer id){
        this.periciaRepository.deleteById(id);
    }

    @Transactional
    public Pericia save(Pericia pericia){
        this.validarPericia(pericia);
        return this.periciaRepository.save(this.preencheData(pericia));
    }

    @Transactional(readOnly = true)
    public boolean existPericia(Integer id) {
        throwIf(id, Objects::isNull, "ID Pericia can not be null");
        return this.periciaRepository.existPericia(id);
    }

    private Pericia preencheData(Pericia pericia){
        if(pericia.getId() == null){
            pericia.setCreated_at(new Date());
        }
        else{
            pericia.setCreated_at(periciaRepository.dataCriacao(pericia.getId()));
        }
        pericia.setUpdated_at(new Date());
        return pericia;
    }

    private void validarPericia(Pericia pericia){
        throwIf(pericia, Objects::isNull, "Pericia can not be null");
    }
}
