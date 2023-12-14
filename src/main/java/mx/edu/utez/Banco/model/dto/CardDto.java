package mx.edu.utez.Banco.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CardDto {
    private Integer id_card;
    private Double creditLimit;
    private String cardNumber;
    private String nameCard;
}
