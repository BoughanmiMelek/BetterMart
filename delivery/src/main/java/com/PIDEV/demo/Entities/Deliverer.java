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
public class Deliverer extends User  {

    private boolean dispo;



    @OneToMany(cascade = CascadeType.ALL, mappedBy="deliverer")
    private Set<Delivery> Deliveries;



}
