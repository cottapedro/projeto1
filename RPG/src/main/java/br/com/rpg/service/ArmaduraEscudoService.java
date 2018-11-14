package br.com.rpg.service;


import br.com.rpg.domain.ArmaduraEscudo;
import br.com.rpg.repository.ArmaduraEscudoRepository;
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
public class ArmaduraEscudoService {

    @NonNull
    private ArmaduraEscudoRepository armaduraEscudoRepository;

    @Transactional(readOnly = true)
    public List<ArmaduraEscudo> findAll(){
        return this.armaduraEscudoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ArmaduraEscudo findById(Integer id){
        return this.armaduraEscudoRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Integer id){
        this.armaduraEscudoRepository.deleteById(id);
    }

    @Transactional
    public ArmaduraEscudo save(ArmaduraEscudo armaduraEscudo){
        this.validarArmaduraEscudo(armaduraEscudo);
        return this.armaduraEscudoRepository.save(this.preencheData(armaduraEscudo));
    }

    @Transactional(readOnly = true)
    public boolean existArmaduraEscudo(Integer id) {
        throwIf(id, Objects::isNull, "ID ArmaduraEscudo can not be null");
        return this.armaduraEscudoRepository.existArmaduraEscudo(id);
    }

    private ArmaduraEscudo preencheData(ArmaduraEscudo armaduraEscudo){
        if(armaduraEscudo.getId() == null){
            armaduraEscudo.setCreated_at(new Date());
        }
        else{
            armaduraEscudo.setCreated_at(armaduraEscudoRepository.dataCriacao(armaduraEscudo.getId()));
        }
        armaduraEscudo.setUpdated_at(new Date());
        return armaduraEscudo;
    }

    private void validarArmaduraEscudo(ArmaduraEscudo armaduraEscudo){
        throwIf(armaduraEscudo, Objects::isNull, "ArmaduraEscudo can not be null");
    }
}
