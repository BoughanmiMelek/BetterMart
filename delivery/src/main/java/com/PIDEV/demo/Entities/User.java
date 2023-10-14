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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name ;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private String login;
    private String password;
    private String role;
    private long tel;
    private String email;


}
