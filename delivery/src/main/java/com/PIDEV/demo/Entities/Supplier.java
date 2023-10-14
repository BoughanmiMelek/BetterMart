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
public class Supplier extends User {

    private String type;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="supplier")
    private Set<Warehouse> warehouses;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="supplier")
    private Set<Suggestion> Suggestions;

}
