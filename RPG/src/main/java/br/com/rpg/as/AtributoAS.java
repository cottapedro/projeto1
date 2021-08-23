package br.com.rpg.as;

import static br.com.rpg.comum.ValidacaoUtils.throwIf;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rpg.domain.Atributo;
import br.com.rpg.dto.input.IAtributoDTO;
import br.com.rpg.dto.output.OAtributoDTO;
import br.com.rpg.service.AtributoService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtributoAS {

    @NonNull
    private AtributoService atributoService;
    @NonNull
    private ConverterMapper mapper;

    @Transactional(readOnly = true)
    public List<OAtributoDTO> findAll(){
        List<Atributo> atributos = this.atributoService.findAll();
        return this.mapper.mapAsList(atributos, OAtributoDTO.class);
    }

    @Transactional(readOnly = true)
    public OAtributoDTO findById(Integer id){
    	Atributo atributo = this.atributoService.findById(id);
        return mapper.map(atributo, OAtributoDTO.class);
    }

    @Transactional
    public void deleteById(Integer id) {
        this.atributoService.deleteById(id);
    }

    @Transactional
    public OAtributoDTO save(IAtributoDTO atributoDTO){
    	Atributo atributo = this.mapper.map(atributoDTO, Atributo.class);
    	atributo = this.atributoService.save(atributo);
        return this.mapper.map(atributo, OAtributoDTO.class);
    }

    @Transactional
    public OAtributoDTO update(Integer id, IAtributoDTO atributoDTO) {
        validar(id);
        Atributo atributo = this.mapper.map(atributoDTO, Atributo.class);
        atributo.setId(id);
        atributo = this.atributoService.save(atributo);
        return this.mapper.map(atributo, OAtributoDTO.class);
    }

    private void validar(Integer id) {
        throwIf(id, Objects::isNull, "ID Pericia can not be null");
        boolean existAtributo = this.atributoService.existAtributo(id);
        throwIf(existAtributo, Boolean.FALSE::equals, "Pericia does not already exist");
    }
}
