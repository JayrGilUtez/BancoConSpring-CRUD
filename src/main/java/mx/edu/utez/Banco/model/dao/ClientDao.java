package mx.edu.utez.Banco.model.dao;

import mx.edu.utez.Banco.model.entity.ClientBean;
import org.springframework.data.repository.CrudRepository;

public interface ClientDao extends CrudRepository<ClientBean, Integer> {
}
