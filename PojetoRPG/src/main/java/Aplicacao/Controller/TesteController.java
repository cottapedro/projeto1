package Aplicacao.Controller;

import Aplicacao.DAO.TesteDAO;
import Aplicacao.Model.TesteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    private TesteDAO testeDAO;


    @RequestMapping("/testar")
    public String testar(){
        return "metodo de teste";
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<TesteModel> listar(){
        return testeDAO.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void inserir(@RequestParam("id") Long id, @RequestParam("nome") String nome,
                          @RequestParam("email") String email){

        TesteModel testeModel = new TesteModel(id,nome,email);
        testeDAO.save(testeModel);
    }
}
