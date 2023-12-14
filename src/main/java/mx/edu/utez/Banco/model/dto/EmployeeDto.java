package mx.edu.utez.Banco.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class EmployeeDto {
    private Integer id_employee;
    private Integer employee_number;
    private String admition_date;
    private Integer branch_idbranch;
    private Integer person_idperson;
}
