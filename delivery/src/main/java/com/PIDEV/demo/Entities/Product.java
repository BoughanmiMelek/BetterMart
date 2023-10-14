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
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idProduct;

    private String referance;
    private String name;
    private float price;
    private  String descrp;
    private  String category;
    private  int quantite;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="product")
    private Set<CommandLigne> CommandLignes;

    @ManyToOne
    private Discount discount;

    @ManyToOne
    private Warehouse warehouse;
}
