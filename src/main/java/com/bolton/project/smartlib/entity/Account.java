package com.bolton.project.smartlib.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {

    @Id
    private String acid;
    private int activestatus;
    private String acctype;

    @OneToOne(mappedBy = "account")
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @OneToMany(mappedBy = "account")
    private List<Library> libraryList;

}
