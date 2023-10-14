package com.PIDEV.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PurchaseOrder  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idDemand;
    private String productName;
    private String descriptionPO;
    private Integer quantityPO;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="purchaseOrder")
    private Set<Suggestion> Suggestions;

    @ManyToOne
    private Customer customer;
}
