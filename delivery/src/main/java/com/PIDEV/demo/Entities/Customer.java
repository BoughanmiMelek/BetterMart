package com.PIDEV.demo.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Customer extends User {

    private int points;
    private int cin;
    private String address;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
    private Set<PurchaseOrder> PurchaseOrders;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
    private Set<Reaction> Reactions;



    @OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
    private Set<Orderr> orderrs;

}
