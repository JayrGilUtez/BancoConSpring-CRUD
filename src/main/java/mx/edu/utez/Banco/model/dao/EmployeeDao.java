package mx.edu.utez.Banco.model.dao;

import mx.edu.utez.Banco.model.entity.EmployeeBean;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<EmployeeBean, Integer> {
}
