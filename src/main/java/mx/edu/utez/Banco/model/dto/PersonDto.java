package mx.edu.utez.Banco.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PersonDto {
    private Integer id_person;
    private String address;
    private String ap1;
    private String ap2;
    private String birthdate;
    private String name;
}
