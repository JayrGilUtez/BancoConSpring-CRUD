package mx.edu.utez.Banco.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
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
@ToString
@Table(name = "card")
public class CardBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_card")
    private Integer idCard;
    @Column(name = "name_card", nullable = false)
    private String nameCard;
    @Column(name = "credit_limit", nullable = false)
    private Double creditLimit;
    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @ManyToMany
    @JoinTable(name = "client_has_card", joinColumns = @JoinColumn(name = "card_id"),
    inverseJoinColumns = @JoinColumn(name = "client_id"))
    @JsonIgnore
    private Set<ClientBean> clients = new HashSet<>();

}
