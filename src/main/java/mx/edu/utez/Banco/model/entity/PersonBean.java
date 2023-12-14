package mx.edu.utez.Banco.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "person")
public class PersonBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Integer idPerson;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "ap1", nullable = false)
    private String ap1;
    @Column(name = "ap2", nullable = false)
    private String ap2;
    @Column(name = "birthdate", nullable = false)
    private String birthdate;
    @Column(name = "address", nullable = false)
    private String address;

    @OneToOne(mappedBy = "personBean", cascade = CascadeType.ALL)
    private ClientBean clientBean;

    @OneToOne(mappedBy = "personBean", cascade = CascadeType.ALL)
    @JsonIgnore
    private EmployeeBean employeeBean;
}
