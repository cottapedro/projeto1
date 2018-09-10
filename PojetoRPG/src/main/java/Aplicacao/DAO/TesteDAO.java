package Aplicacao.DAO;

import Aplicacao.Model.TesteModel;

import java.util.ArrayList;
import java.util.List;

public class TesteDAO {
    private static List<TesteModel> testeModels;

    public TesteDAO(){
        testeModels = new ArrayList<>();
        testeModels.add(new TesteModel(1L, "madoka", "madoka@magica.com.br"));
        testeModels.add(new TesteModel(2L, "doutor", "doutor@gmail.com.br"));
        testeModels.add(new TesteModel(3L, "cotta", "cotta@gmail.com.br"));
        testeModels.add(new TesteModel(4L, "ivan", "ivan@gmail.com.br"));
    }

    public List<TesteModel> listar() {
        return testeModels;
    }

}
