package Aplicacao.Controller;

import Aplicacao.DAO.TesteDAO;
import Aplicacao.Model.TesteModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @RequestMapping("/testar")
    public String testar(){
        return "metodo de teste";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TesteModel> listar(){
        TesteDAO testeDAO = new TesteDAO();
        return testeDAO.listar();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void inserir(@RequestParam("id") Long id, @RequestParam("nome") String nome,
                          @RequestParam("email") String email){
        TesteDAO testeDAO = new TesteDAO();
        testeDAO.inserir(id,nome,email);
    }
}
