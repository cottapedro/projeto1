package br.com.rpg.as;

import br.com.rpg.domain.Raca;
import br.com.rpg.dto.RacaDTO;
import br.com.rpg.service.RacaService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static br.com.rpg.comum.ValidacaoUtils.throwIf;

@Service
@RequiredArgsConstructor
public class RacaAS {

    @NonNull
    private RacaService racaService;
    @NonNull
    private ConverterMapper mapper;

    @Transactional(readOnly = true)
    public List<RacaDTO> findAll(){
        List<Raca> racas = this.racaService.findAll();
        return this.mapper.mapAsList(racas, RacaDTO.class);
    }

    @Transactional(readOnly = true)
    public RacaDTO findById(Integer id){
        Raca raca = this.racaService.findById(id);
        return mapper.map(raca, RacaDTO.class);
    }

    @Transactional
    public void deleteById(Integer id) {
        this.racaService.deleteById(id);
    }

    @Transactional
    public RacaDTO save(RacaDTO racadto){
        Raca raca = this.mapper.map(racadto, Raca.class);
        raca = this.racaService.save(raca);
        return this.mapper.map(raca, RacaDTO.class);
    }

    @Transactional
    public RacaDTO update(Integer id, RacaDTO racaDTO) {
        throwIf(id, Objects::isNull, "ID Raca can not be null");
        boolean existRaca = this.racaService.existRaca(id);
        throwIf(existRaca, Boolean.FALSE::equals, "Raca does not already exist");
        racaDTO.setId(id);
        return this.save(racaDTO);
    }
}
