package mx.edu.utez.Banco.service;

import mx.edu.utez.Banco.model.dto.CardDto;
import mx.edu.utez.Banco.model.entity.CardBean;

import java.util.List;

public interface ICard {
    CardBean save(CardDto card);

    CardBean findById(Integer id);

    List<CardBean> findAll();

    void delete(CardBean card);
}
