package Aplicacao.Controller;

import Aplicacao.DAO.TesteDAO;
import Aplicacao.Model.TesteModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
