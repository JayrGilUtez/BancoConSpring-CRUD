package mx.edu.utez.Banco.controller;

import mx.edu.utez.Banco.model.dto.PersonDto;
import mx.edu.utez.Banco.model.entity.PersonBean;
import mx.edu.utez.Banco.service.IPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {
    @Autowired
    private IPerson personService;

    @GetMapping("/")
    public List<PersonBean> getPerson() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public PersonBean showById(@PathVariable Integer id) {
        return personService.findById(id);
    }

    @PostMapping("/")
    public PersonDto create(@RequestBody PersonDto personDto) {
        PersonBean personSave = personService.save(personDto);
        return PersonDto.builder()
                .id_person(personSave.getIdPerson())
                .address(personSave.getAddress())
                .ap1(personSave.getAp1())
                .ap2(personSave.getAp2())
                .birthdate(personSave.getBirthdate())
                .name(personSave.getName())
                .build();
    }

    @PutMapping("/")
    public PersonDto update(@RequestBody PersonDto personDto) {
        PersonBean personUpdate = personService.save(personDto);
        return PersonDto.builder()
                .id_person(personUpdate.getIdPerson())
                .address(personUpdate.getAddress())
                .ap1(personUpdate.getAp1())
                .ap2(personUpdate.getAp2())
                .birthdate(personUpdate.getBirthdate())
                .name(personUpdate.getName())
                .build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        PersonBean person = personService.findById(id);
        personService.delete(person);
    }
}
