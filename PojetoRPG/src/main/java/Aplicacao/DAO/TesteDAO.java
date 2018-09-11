package Aplicacao.DAO;

import Aplicacao.Model.TesteModel;
import org.springframework.data.repository.CrudRepository;

public interface TesteDAO  extends CrudRepository<TesteModel,String> {

}
