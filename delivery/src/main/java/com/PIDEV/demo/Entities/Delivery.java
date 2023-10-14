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
public class Delivery implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idD;
    private String reference;

    private  String name_Customer;
    private  float total;
    private  String refOrder;
    private String adrss;
    private String point;


    @Temporal(TemporalType.DATE)
    private Date  date;


    @JsonIgnore
    @ManyToOne
    private Deliverer deliverer;


    @JsonIgnore
    @ManyToOne
    private RelyPoint relyPoint;


    //@JsonIgnore:ajouter jsonignore seulement dans cette entite
    //si je veux afficher les details de order
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private  Orderr orderr; 


    public Delivery(int idd, String reference, java.sql.Date date) {
        this.idD = idd;
        this.reference = reference;
        this.date = date;
    }


}
