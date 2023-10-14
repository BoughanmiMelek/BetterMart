package com.PIDEV.demo.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Suggestion  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idS;

    private float price;
    @Temporal(TemporalType.DATE)
    private Date dure;
    private String statue;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private PurchaseOrder purchaseOrder;

}
