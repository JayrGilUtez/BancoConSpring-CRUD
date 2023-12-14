package mx.edu.utez.Banco.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BranchDto {
    private Integer id_branch;
    private String code;
    private String address;
    private String name;
}
