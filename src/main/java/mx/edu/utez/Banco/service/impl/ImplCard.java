package mx.edu.utez.Banco.service.impl;

import mx.edu.utez.Banco.model.dao.CardDao;
import mx.edu.utez.Banco.model.dto.CardDto;
import mx.edu.utez.Banco.model.entity.CardBean;
import mx.edu.utez.Banco.service.ICard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplCard implements ICard {
    @Autowired
    private CardDao cardDao;

    @Override
    @Transactional
    public CardBean save(CardDto cardDto) {
        CardBean card = CardBean.builder()
                .idCard(cardDto.getId_card())
                .creditLimit(cardDto.getCreditLimit())
                .cardNumber(cardDto.getCardNumber())
                .nameCard(cardDto.getNameCard())
                .build();
        return cardDao.save(card);
    }

    @Override
    @Transactional(readOnly = true)
    public CardBean findById(Integer id) {
        return cardDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CardBean> findAll() {
        return (List<CardBean>) cardDao.findAll();
    }

    @Override
    @Transactional
    public void delete(CardBean card) {
        cardDao.delete(card);
    }
}
