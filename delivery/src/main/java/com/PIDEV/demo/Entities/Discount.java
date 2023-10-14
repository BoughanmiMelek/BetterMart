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
public class Discount  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idDiscount;
    private Integer code;
    private float amountCode;
    private String descriptionD;
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="discount")
    private Set<Product> products;
}
