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
public class Publication implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idPub;
    @Temporal(TemporalType.DATE)
    private Date datePub;
    private String imagePub;
    private String pub;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="publication")
    private Set<Claim> claims;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="publication")
    private Set<Comment> comments;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reaction> reactions;

}
