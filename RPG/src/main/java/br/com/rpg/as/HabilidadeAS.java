package br.com.rpg.as;

import br.com.rpg.domain.Habilidade;
import br.com.rpg.dto.output.OHabilidadeDTO;
import br.com.rpg.dto.input.IHabilidadeDTO;
import br.com.rpg.service.HabilidadeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static br.com.rpg.comum.ValidacaoUtils.throwIf;

@Service
@RequiredArgsConstructor
public class HabilidadeAS {

    @NonNull
    private HabilidadeService habilidadeService;
    @NonNull
    private ConverterMapper mapper;

    @Transactional(readOnly = true)
    public List<OHabilidadeDTO> findAll(){
        List<Habilidade> habilidades = this.habilidadeService.findAll();
        return this.mapper.mapAsList(habilidades, OHabilidadeDTO.class);
    }

    @Transactional(readOnly = true)
    public OHabilidadeDTO findById(Integer id){
        Habilidade habilidade = this.habilidadeService.findById(id);
        return mapper.map(habilidade, OHabilidadeDTO.class);
    }

    @Transactional
    public void deleteById(Integer id) {
        this.habilidadeService.deleteById(id);
    }

    @Transactional
    public OHabilidadeDTO save(IHabilidadeDTO habilidadeRacadto){
        Habilidade habilidade = this.mapper.map(habilidadeRacadto, Habilidade.class);
        habilidade = this.habilidadeService.save(habilidade);
        return this.mapper.map(habilidade, OHabilidadeDTO.class);
    }

    @Transactional
    public OHabilidadeDTO update(Integer id, IHabilidadeDTO habilidadeDTO) {
        this.valida(id);
        Habilidade habilidade = this.mapper.map(habilidadeDTO, Habilidade.class);
        habilidade.setId(id);
        habilidade = this.habilidadeService.save(habilidade);
        return this.mapper.map(habilidade, OHabilidadeDTO.class);
    }

    private void valida(Integer id) {
        throwIf(id, Objects::isNull, "ID HabilidadeRaca can not be null");
        boolean existHabilidadeRaca = this.habilidadeService.existHabilidadeRaca(id);
        throwIf(existHabilidadeRaca, Boolean.FALSE::equals, "HabilidadeRaca does not already exist");
    }
}
