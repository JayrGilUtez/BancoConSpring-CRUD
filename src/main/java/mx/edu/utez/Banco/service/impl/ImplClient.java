package mx.edu.utez.Banco.service.impl;

import lombok.AllArgsConstructor;
import mx.edu.utez.Banco.model.dao.BranchDao;
import mx.edu.utez.Banco.model.dao.CardDao;
import mx.edu.utez.Banco.model.dao.ClientDao;
import mx.edu.utez.Banco.model.dao.PersonDao;
import mx.edu.utez.Banco.model.dto.CardDto;
import mx.edu.utez.Banco.model.dto.ClientDto;
import mx.edu.utez.Banco.model.entity.BranchBean;
import mx.edu.utez.Banco.model.entity.CardBean;
import mx.edu.utez.Banco.model.entity.ClientBean;
import mx.edu.utez.Banco.model.entity.PersonBean;
import mx.edu.utez.Banco.service.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ImplClient implements IClient {

    private final ClientDao clientDao;
    private final BranchDao branchDao;
    private final PersonDao personDao;
    private final CardDao cardDao;

    @Override
    @Transactional(rollbackFor = {SQLException.class})
    public ClientBean save(ClientDto clientDto) {
        BranchBean branchBean = branchDao.findById(clientDto.getBranch_idbranch()).orElse(null);
        PersonBean personBean = personDao.findById(clientDto.getPerson_idperson()).orElse(null);
        ClientBean client = ClientBean.builder()
                .idClient(clientDto.getId_client())
                .account(clientDto.getAccount())
                .type(clientDto.getType())
                .branchBean(branchBean)
                .personBean(personBean)
                .build();
        Set<CardBean> cards = new HashSet<>();
        Set<ClientBean> clients = new HashSet<>();
        clients.add(client);
        cardDao.findAllById(clientDto.getCards()).forEach(card -> {
            clients.addAll(card.getClients()) ;
            card.setClients(clients);
            cards.add(card);
        });
        client.setCards(cards);
        return clientDao.save(client);
    }

    @Override
    public ClientBean findById(Integer id) {
        return null;
    }

    @Override
    public List<ClientBean> findAll() {
        return (List<ClientBean>) clientDao.findAll();
    }

    @Override
    public void delete(ClientBean clientBean) {

    }
}
