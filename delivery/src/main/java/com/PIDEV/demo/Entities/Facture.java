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
public class Facture  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idF;
    private  String ref;
    @Temporal(TemporalType.DATE)
    private Date dateFac ;

    @OneToOne(mappedBy="facture")
    private Orderr order;
}
