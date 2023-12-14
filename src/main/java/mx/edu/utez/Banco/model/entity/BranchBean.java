package mx.edu.utez.Banco.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "branch")

public class BranchBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_branch")
    private Integer idBranch;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "code", nullable = false)
    private String code;

    @OneToOne(mappedBy = "branchBean", cascade = CascadeType.ALL)
    @JsonIgnore
    private EmployeeBean employeeBean;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "branchBean")
    @JsonIgnore    private Set<ClientBean> clients = new HashSet<>();
}