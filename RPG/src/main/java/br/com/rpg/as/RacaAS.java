package br.com.rpg.as;

import static br.com.rpg.comum.ValidacaoUtils.throwIf;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rpg.domain.Raca;
import br.com.rpg.dto.input.IRacaDTO;
import br.com.rpg.dto.output.ORacaDTO;
import br.com.rpg.service.RacaService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RacaAS {

    @NonNull
    private RacaService racaService;
    @NonNull
    private ConverterMapper mapper;

    @Transactional(readOnly = true)
    public List<ORacaDTO> findAll(){
        List<Raca> racas = this.racaService.findAll();
        return this.mapper.mapAsList(racas, ORacaDTO.class);
    }

    @Transactional(readOnly = true)
    public ORacaDTO findById(Integer id){
        Raca raca = this.racaService.findById(id);
        return mapper.map(raca, ORacaDTO.class);
    }

    @Transactional
    public void deleteById(Integer id) {
        this.racaService.deleteById(id);
    }

    @Transactional
    public ORacaDTO save(IRacaDTO racaDTO){
        Raca raca = this.mapper.map(racaDTO, Raca.class);
        raca = this.racaService.save(raca);
        return this.mapper.map(raca, ORacaDTO.class);
    }

    @Transactional
    public ORacaDTO update(Integer id, IRacaDTO racaDTO) {
        validar(id);
        Raca raca = this.mapper.map(racaDTO, Raca.class);
        raca.setId(id);
        raca = this.racaService.save(raca);
        return this.mapper.map(raca, ORacaDTO.class);
    }

    private void validar(Integer id) {
        throwIf(id, Objects::isNull, "ID Raca can not be null");
        boolean existRaca = this.racaService.existRaca(id);
        throwIf(existRaca, Boolean.FALSE::equals, "Raca does not already exist");
    }
}
