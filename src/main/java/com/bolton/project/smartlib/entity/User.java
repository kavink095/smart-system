package com.bolton.project.smartlib.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "userid")
    private String userid;
    @Column(name = "userfname")
    private String userfname;
    @Column(name = "userlname")
    private String userlname;
    @Column(name = "useraddress")
    private String useraddress;
    @Column(name = "usermobile")
    private String usermobile;
    @Column(name = "useractivestatus")
    private int useractivestatus;

    @OneToMany(mappedBy = "user")
    private List<Rent> rentList;

    @OneToOne(mappedBy = "user")
    private Account account;

    @OneToMany(mappedBy = "user")
    private List<UserEnter> userEnterList;

    public User() {
    }


}
