package mx.edu.utez.Banco.controller;

import mx.edu.utez.Banco.model.dto.CardDto;
import mx.edu.utez.Banco.model.entity.CardBean;
import mx.edu.utez.Banco.service.ICard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/card")
@CrossOrigin
public class CardController {
    @Autowired
    private ICard cardService;

    @GetMapping("/")
    public List<CardBean> getCards() {
        return cardService.findAll();
    }

    @GetMapping("/{id}")
    public CardBean showById(@PathVariable Integer id) {
        return cardService.findById(id);
    }

    @PostMapping("/")
    public CardDto create(@RequestBody CardDto cardDto) {
        CardBean cardSave = cardService.save(cardDto);
        return CardDto.builder()
                .id_card(cardSave.getIdCard())
                .creditLimit(cardSave.getCreditLimit())
                .cardNumber(cardSave.getCardNumber())
                .nameCard(cardSave.getNameCard())
                .build();
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody CardDto cardDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            CardBean cardUpdate = cardService.save(cardDto);
            return new ResponseEntity<>(cardUpdate, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar la tarjeta");
            response.put("Card", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    public CardDto update(@RequestBody CardDto cardDto) {
//        CardBean cardUpdate = cardService.save(cardDto);
//        return CardDto.builder()
//                .id_card(cardDto.getId_card())
//                .credit_limit(cardDto.getCredit_limit())
//                .credit_number(cardDto.getCredit_number())
//                .name_card(cardDto.getName_card())
//                .build();
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            CardBean card = cardService.findById(id);
            cardService.delete(card);
            return new ResponseEntity<>(card, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar la tarjeta");
            response.put("Card", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
