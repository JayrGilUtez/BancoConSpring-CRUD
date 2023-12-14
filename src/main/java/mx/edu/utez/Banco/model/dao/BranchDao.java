package mx.edu.utez.Banco.model.dao;

import mx.edu.utez.Banco.model.entity.BranchBean;
import org.springframework.data.repository.CrudRepository;

public interface BranchDao extends CrudRepository<BranchBean, Integer> {
}
