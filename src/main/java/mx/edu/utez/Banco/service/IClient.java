package mx.edu.utez.Banco.service;


import mx.edu.utez.Banco.model.dto.ClientDto;
import mx.edu.utez.Banco.model.entity.ClientBean;

import java.util.List;

public interface IClient {
    ClientBean save(ClientDto clientDto);

    ClientBean findById(Integer id);

    List<ClientBean> findAll();

    void delete(ClientBean clientBean);
}
