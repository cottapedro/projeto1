package br.com.rpg.as;

import br.com.rpg.domain.Teste;
import br.com.rpg.dto.TesteDTO;
import br.com.rpg.service.TesteService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import static br.com.rpg.comum.ValidacaoUtils.throwIf;

@Service
@RequiredArgsConstructor
public class TesteAS {

    @NonNull
    private TesteService testeService;
    @NonNull
    private ConverterMapper mapper;

    @Transactional(readOnly = true)
    public List<TesteDTO> findAll(){
        List<Teste> testes = this.testeService.findAll();
        return this.mapper.mapAsList(testes, TesteDTO.class);
    }

    @Transactional(readOnly = true)
    public TesteDTO findById(Integer id){
        Teste teste = this.testeService.findById(id);
        return mapper.map(teste, TesteDTO.class);
    }

    @Transactional
    public void deleteById(Integer id) {
        this.testeService.deleteById(id);
    }

    @Transactional
    public TesteDTO save(TesteDTO testeDTO){
        Teste job = this.mapper.map(testeDTO, Teste.class);
        job = this.testeService.save(job);
        return this.mapper.map(job, TesteDTO.class);
    }

    @Transactional
    public TesteDTO update(Integer id, TesteDTO testeDTO) {
        throwIf(id, Objects::isNull, "ID Teste can not be null");
        boolean existTeste = this.testeService.existTeste(id);
        throwIf(existTeste, Boolean.FALSE::equals, "Teste does not already exist");
        testeDTO.setId(id);
        return this.save(testeDTO);
    }
}
