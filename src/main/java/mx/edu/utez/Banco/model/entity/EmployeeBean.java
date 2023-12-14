package mx.edu.utez.Banco.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "employee")

public class EmployeeBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Integer idEmployee;
    @Column(name = "employee_number", nullable = false)
    private Integer emplNumber;
    @Column(name = "admition_date", nullable = false)
    private String adminDate;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "branch_id")
    private BranchBean branchBean;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "person_id")
    private PersonBean personBean;

}
