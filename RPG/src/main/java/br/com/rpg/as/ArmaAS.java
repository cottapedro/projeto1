package br.com.rpg.as;

import static br.com.rpg.comum.ValidacaoUtils.throwIf;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rpg.domain.Arma;
import br.com.rpg.dto.input.IArmaDTO;
import br.com.rpg.dto.output.OArmaDTO;
import br.com.rpg.service.ArmaService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArmaAS {

    @NonNull
    private ArmaService armaService;
    @NonNull
    private ConverterMapper mapper;

    @Transactional(readOnly = true)
    public List<OArmaDTO> findAll(){
        List<Arma> armas = this.armaService.findAll();
        return this.mapper.mapAsList(armas, OArmaDTO.class);
    }

    @Transactional(readOnly = true)
    public OArmaDTO findById(Integer id){
        Arma arma = this.armaService.findById(id);
        return mapper.map(arma, OArmaDTO.class);
    }

    @Transactional
    public void deleteById(Integer id) {
        this.armaService.deleteById(id);
    }

    @Transactional
    public OArmaDTO save(IArmaDTO armaDTO){
        Arma arma = this.mapper.map(armaDTO, Arma.class);
        arma = this.armaService.save(arma);
        return this.mapper.map(arma, OArmaDTO.class);
    }

    @Transactional
    public OArmaDTO update(Integer id, IArmaDTO armaDTO) {
        validar(id);
        Arma arma = this.mapper.map(armaDTO, Arma.class);
        arma.setId(id);
        arma = this.armaService.save(arma);
        return this.mapper.map(arma, OArmaDTO.class);
    }

    private void validar(Integer id) {
        throwIf(id, Objects::isNull, "ID Arma can not be null");
        boolean existArma = this.armaService.existArma(id);
        throwIf(existArma, Boolean.FALSE::equals, "Arma does not already exist");
    }
}
