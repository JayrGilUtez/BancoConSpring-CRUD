package mx.edu.utez.Banco.model.dao;

import mx.edu.utez.Banco.model.entity.CardBean;
import org.springframework.data.repository.CrudRepository;

public interface CardDao extends CrudRepository<CardBean, Integer> {
}
