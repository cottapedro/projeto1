package br.com.rpg.as;

import static br.com.rpg.comum.ValidacaoUtils.throwIf;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rpg.domain.HabilidadeRaca;
import br.com.rpg.dto.input.IHabilidadeRacaDTO;
import br.com.rpg.dto.output.OHabilidadeRacaDTO;
import br.com.rpg.service.HabilidadeRacaService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HabilidadeRacaAS {

    @NonNull
    private HabilidadeRacaService habilidadeRacaService;
    @NonNull
    private ConverterMapper mapper;

    @Transactional(readOnly = true)
    public List<OHabilidadeRacaDTO> findAll(){
        List<HabilidadeRaca> habilidades = this.habilidadeRacaService.findAll();
        return this.mapper.mapAsList(habilidades, OHabilidadeRacaDTO.class);
    }

    @Transactional(readOnly = true)
    public OHabilidadeRacaDTO findById(Integer id){
        HabilidadeRaca habilidadeRaca = this.habilidadeRacaService.findById(id);
        return mapper.map(habilidadeRaca, OHabilidadeRacaDTO.class);
    }

    @Transactional
    public void deleteById(Integer id) {
        this.habilidadeRacaService.deleteById(id);
    }

    @Transactional
    public OHabilidadeRacaDTO save(IHabilidadeRacaDTO habilidadeRacaDTO){
        HabilidadeRaca habilidadeRaca = this.mapper.map(habilidadeRacaDTO, HabilidadeRaca.class);
        habilidadeRaca = this.habilidadeRacaService.save(habilidadeRaca);
        return this.mapper.map(habilidadeRaca, OHabilidadeRacaDTO.class);
    }

    @Transactional
    public OHabilidadeRacaDTO update(Integer id, IHabilidadeRacaDTO habilidadeRacaDTO) {
        this.valida(id);
        HabilidadeRaca habilidadeRaca = this.mapper.map(habilidadeRacaDTO, HabilidadeRaca.class);
        habilidadeRaca.setId(id);
        habilidadeRaca = this.habilidadeRacaService.save(habilidadeRaca);
        return this.mapper.map(habilidadeRaca, OHabilidadeRacaDTO.class);
    }

    private void valida(Integer id) {
        throwIf(id, Objects::isNull, "ID HabilidadeRaca can not be null");
        boolean existHabilidadeRaca = this.habilidadeRacaService.existHabilidadeRaca(id);
        throwIf(existHabilidadeRaca, Boolean.FALSE::equals, "HabilidadeRaca does not already exist");
    }
}
