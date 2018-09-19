package br.com.rpg.service;


import br.com.rpg.domain.Teste;
import br.com.rpg.repository.TesteRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static br.com.rpg.comum.ValidacaoUtils.throwIf;

@Component
@RequiredArgsConstructor
public class TesteService {

    @NonNull
    private TesteRepository testeRepository;

    @Transactional(readOnly = true)
    public List<Teste> findAll(){
        return this.testeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Teste findById(Integer id){
        return this.testeRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Integer id){
        this.testeRepository.deleteById(id);
    }

    @Transactional
    public Teste save(Teste teste){
        this.validarTeste(teste);
        return this.testeRepository.save(teste);
    }

    @Transactional(readOnly = true)
    public boolean existTeste(Integer id) {
        throwIf(id, Objects::isNull, "ID Teste can not be null");
        return this.testeRepository.existTeste(id);
    }

    private void validarTeste(Teste teste){
        throwIf(teste, Objects::isNull, "Teste can not be null");
    }
}
