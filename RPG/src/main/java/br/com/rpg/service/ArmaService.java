package br.com.rpg.service;


import br.com.rpg.domain.Arma;
import br.com.rpg.repository.ArmaRepository;
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
public class ArmaService {

    @NonNull
    private ArmaRepository armaRepository;

    @Transactional(readOnly = true)
    public List<Arma> findAll(){
        return this.armaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Arma findById(Integer id){
        return this.armaRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Integer id){
        this.armaRepository.deleteById(id);
    }

    @Transactional
    public Arma save(Arma arma){
        this.validarArma(arma);
        return this.armaRepository.save(this.preencheData(arma));
    }

    @Transactional(readOnly = true)
    public boolean existArma(Integer id) {
        throwIf(id, Objects::isNull, "ID Arma can not be null");
        return this.armaRepository.existArma(id);
    }

    private Arma preencheData(Arma arma){
        if(arma.getId() == null){
            arma.setCreated_at(new Date());
        }
        else{
            arma.setCreated_at(armaRepository.dataCriacao(arma.getId()));
        }
        arma.setUpdated_at(new Date());
        return arma;
    }

    private void validarArma(Arma arma){
        throwIf(arma, Objects::isNull, "Arma can not be null");
    }
}
