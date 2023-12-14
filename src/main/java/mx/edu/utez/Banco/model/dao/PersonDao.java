package mx.edu.utez.Banco.model.dao;

import mx.edu.utez.Banco.model.entity.PersonBean;
import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<PersonBean, Integer> {
}
