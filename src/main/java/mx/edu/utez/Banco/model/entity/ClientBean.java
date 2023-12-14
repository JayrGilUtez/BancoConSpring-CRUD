package mx.edu.utez.Banco.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "client")
public class ClientBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Integer idClient;
    @Column(name = "account", nullable = false)
    private String account;
    @Column(name = "type", nullable = false)
    private String type;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "person_id")
    @JsonIgnoreProperties({"clientBean"})
    private PersonBean personBean;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "branch_id")
    @JsonIgnoreProperties({"clients"})
    private BranchBean branchBean;

    @ManyToMany(mappedBy = "clients")
    @JsonIgnoreProperties({"clients"})
    private Set<CardBean> cards = new HashSet<>();

}
