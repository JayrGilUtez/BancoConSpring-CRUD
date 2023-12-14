package mx.edu.utez.Banco.service.impl;


import mx.edu.utez.Banco.model.dao.PersonDao;
import mx.edu.utez.Banco.model.dto.PersonDto;
import mx.edu.utez.Banco.model.entity.PersonBean;
import mx.edu.utez.Banco.service.IPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplPerson implements IPerson {
    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional
    public PersonBean save(PersonDto personDto) {
        PersonBean person = PersonBean.builder()
                .idPerson(personDto.getId_person())
                .address(personDto.getAddress())
                .ap1(personDto.getAp1())
                .ap2(personDto.getAp2())
                .birthdate(personDto.getBirthdate())
                .name(personDto.getName())
                .build();
        return personDao.save(person);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonBean findById(Integer id) {
        return personDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonBean> findAll() {
        return (List<PersonBean>) personDao.findAll();
    }

    @Override
    @Transactional
    public void delete(PersonBean person) {
        personDao.delete(person);
    }
}
