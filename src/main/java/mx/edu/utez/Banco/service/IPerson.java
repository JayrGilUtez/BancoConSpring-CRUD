package mx.edu.utez.Banco.service;

import mx.edu.utez.Banco.model.dto.PersonDto;
import mx.edu.utez.Banco.model.entity.PersonBean;

import java.util.List;

public interface IPerson {
    PersonBean save(PersonDto person);

    PersonBean findById(Integer id);

    List<PersonBean> findAll();

    void delete(PersonBean person);
}
