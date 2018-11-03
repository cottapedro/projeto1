package br.com.rpg.as;

import br.com.rpg.domain.HabilidadeRaca;
import br.com.rpg.dto.HabilidadeRacaDTO;
import br.com.rpg.service.HabilidadeRacaService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static br.com.rpg.comum.ValidacaoUtils.throwIf;

@Service
@RequiredArgsConstructor
public class HabilidadeRacaAS {

    @NonNull
    private HabilidadeRacaService habilidadeRacaService;
    @NonNull
    private ConverterMapper mapper;

    @Transactional(readOnly = true)
    public List<HabilidadeRacaDTO> findAll(){
        List<HabilidadeRaca> habilidadeRacas = this.habilidadeRacaService.findAll();
        return this.mapper.mapAsList(habilidadeRacas, HabilidadeRacaDTO.class);
    }

    @Transactional(readOnly = true)
    public HabilidadeRacaDTO findById(Integer id){
        HabilidadeRaca habilidadeRaca = this.habilidadeRacaService.findById(id);
        return mapper.map(habilidadeRaca, HabilidadeRacaDTO.class);
    }

    @Transactional
    public void deleteById(Integer id) {
        this.habilidadeRacaService.deleteById(id);
    }

    @Transactional
    public HabilidadeRacaDTO save(HabilidadeRacaDTO habilidadeRacadto){
        HabilidadeRaca habilidadeRaca = this.mapper.map(habilidadeRacadto, HabilidadeRaca.class);
        habilidadeRaca = this.habilidadeRacaService.save(habilidadeRaca);
        return this.mapper.map(habilidadeRaca, HabilidadeRacaDTO.class);
    }

    @Transactional
    public HabilidadeRacaDTO update(Integer id, HabilidadeRacaDTO habilidadeRacaDTO) {
        throwIf(id, Objects::isNull, "ID HabilidadeRaca can not be null");
        boolean existHabilidadeRaca = this.habilidadeRacaService.existHabilidadeRaca(id);
        throwIf(existHabilidadeRaca, Boolean.FALSE::equals, "HabilidadeRaca does not already exist");
        habilidadeRacaDTO.setId(id);
        return this.save(habilidadeRacaDTO);
    }
}
