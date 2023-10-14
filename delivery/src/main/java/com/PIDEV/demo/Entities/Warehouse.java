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
public class Warehouse  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idW;

    private String reference ;
    private  int capacite ;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="warehouse")
    private Set<Product> Products;

    @ManyToOne
    private Supplier supplier;
}
