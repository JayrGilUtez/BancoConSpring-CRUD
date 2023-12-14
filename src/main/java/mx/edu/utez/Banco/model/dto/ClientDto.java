package mx.edu.utez.Banco.model.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClientDto {
    private Integer id_client;
    private String account;
    private String type;
    private Integer branch_idbranch;
    private Integer person_idperson;
    private List<Integer> cards;
}
