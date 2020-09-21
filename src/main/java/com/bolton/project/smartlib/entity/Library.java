package com.bolton.project.smartlib.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "library")
public class Library {
    @Id
    @Column(name = "libid")
    private int libid;
    @Column(name = "libname")
    private String libname;
    @Column(name = "libcontact")
    private String libcontact;
    @Column(name = "libaddress")
    private String libaddress;
    @Column(name = "libcity")
    private String libcity;

    @OneToMany(mappedBy = "library")
    private List<User> userList;

    @OneToMany(mappedBy = "library")
    private List<Rack> rackList;

    public Library() {
    }
}
