package br.com.rpg.as;

import br.com.rpg.domain.ArmaduraEscudo;
import br.com.rpg.dto.input.IArmaduraEscudoDTO;
import br.com.rpg.dto.output.OArmaduraEscudoDTO;
import br.com.rpg.service.ArmaduraEscudoService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static br.com.rpg.comum.ValidacaoUtils.throwIf;

@Service
@RequiredArgsConstructor
public class ArmaduraEscudoAS {

    @NonNull
    private ArmaduraEscudoService armaduraEscudoService;
    @NonNull
    private ConverterMapper mapper;

    @Transactional(readOnly = true)
    public List<OArmaduraEscudoDTO> findAll(){
        List<ArmaduraEscudo> armaduraEscudos = this.armaduraEscudoService.findAll();
        return this.mapper.mapAsList(armaduraEscudos, OArmaduraEscudoDTO.class);
    }

    @Transactional(readOnly = true)
    public OArmaduraEscudoDTO findById(Integer id){
        ArmaduraEscudo armaduraEscudo = this.armaduraEscudoService.findById(id);
        return mapper.map(armaduraEscudo, OArmaduraEscudoDTO.class);
    }

    @Transactional
    public void deleteById(Integer id) {
        this.armaduraEscudoService.deleteById(id);
    }

    @Transactional
    public OArmaduraEscudoDTO save(IArmaduraEscudoDTO armaduraEscudoDTO){
        ArmaduraEscudo armaduraEscudo = this.mapper.map(armaduraEscudoDTO, ArmaduraEscudo.class);
        armaduraEscudo = this.armaduraEscudoService.save(armaduraEscudo);
        return this.mapper.map(armaduraEscudo, OArmaduraEscudoDTO.class);
    }

    @Transactional
    public OArmaduraEscudoDTO update(Integer id, IArmaduraEscudoDTO armaduraEscudoDTO) {
        validar(id);
        ArmaduraEscudo armaduraEscudo = this.mapper.map(armaduraEscudoDTO, ArmaduraEscudo.class);
        armaduraEscudo.setId(id);
        armaduraEscudo = this.armaduraEscudoService.save(armaduraEscudo);
        return this.mapper.map(armaduraEscudo, OArmaduraEscudoDTO.class);
    }

    private void validar(Integer id) {
        throwIf(id, Objects::isNull, "ID ArmaduraEscudo can not be null");
        boolean existArmaduraEscudo = this.armaduraEscudoService.existArmaduraEscudo(id);
        throwIf(existArmaduraEscudo, Boolean.FALSE::equals, "ArmaduraEscudo does not already exist");
    }
}
