package br.com.rpg.as;

import br.com.rpg.domain.Pericia;
import br.com.rpg.dto.input.IPericiaDTO;
import br.com.rpg.dto.output.OPericiaDTO;
import br.com.rpg.service.PericiaService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static br.com.rpg.comum.ValidacaoUtils.throwIf;

@Service
@RequiredArgsConstructor
public class PericiaAS {

    @NonNull
    private PericiaService periciaService;
    @NonNull
    private ConverterMapper mapper;

    @Transactional(readOnly = true)
    public List<OPericiaDTO> findAll(){
        List<Pericia> pericias = this.periciaService.findAll();
        return this.mapper.mapAsList(pericias, OPericiaDTO.class);
    }

    @Transactional(readOnly = true)
    public OPericiaDTO findById(Integer id){
        Pericia pericia = this.periciaService.findById(id);
        return mapper.map(pericia, OPericiaDTO.class);
    }

    @Transactional
    public void deleteById(Integer id) {
        this.periciaService.deleteById(id);
    }

    @Transactional
    public OPericiaDTO save(IPericiaDTO periciaDTO){
        Pericia pericia = this.mapper.map(periciaDTO, Pericia.class);
        pericia = this.periciaService.save(pericia);
        return this.mapper.map(pericia, OPericiaDTO.class);
    }

    @Transactional
    public OPericiaDTO update(Integer id, IPericiaDTO periciaDTO) {
        validar(id);
        Pericia pericia = this.mapper.map(periciaDTO, Pericia.class);
        pericia.setId(id);
        pericia = this.periciaService.save(pericia);
        return this.mapper.map(pericia, OPericiaDTO.class);
    }

    private void validar(Integer id) {
        throwIf(id, Objects::isNull, "ID Pericia can not be null");
        boolean existPericia = this.periciaService.existPericia(id);
        throwIf(existPericia, Boolean.FALSE::equals, "Pericia does not already exist");
    }
}
