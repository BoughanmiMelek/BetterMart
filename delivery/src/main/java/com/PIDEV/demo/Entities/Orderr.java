package com.PIDEV.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Orderr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ido;
    private  String refer;
    @Temporal(TemporalType.DATE)
    private Date dateOrder ;
    private String state;

    private String mail;
    private Boolean relyp;
    private float  prixTotal;


    @OneToOne
    private Facture facture;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="order")
    private Set<CommandLigne> CommandLignes;


    @JsonIgnore
    @ManyToOne
    private  Customer customer;


    @OneToOne(mappedBy="orderr")
    private Delivery delivery;

}






