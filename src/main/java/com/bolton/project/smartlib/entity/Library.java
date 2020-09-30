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

    @ManyToOne
    @JoinColumn(name = "acid", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "rackid", nullable = false)
    private Rack rack;

    @OneToMany(mappedBy = "library")
    private List<User> userList;

    @OneToMany(mappedBy = "library")
    private List<Rack> rackList;

    public Library() {
    }

    public Library(int libid, String libname, String libcontact, String libaddress, String libcity) {
        this.libid = libid;
        this.libname = libname;
        this.libcontact = libcontact;
        this.libaddress = libaddress;
        this.libcity = libcity;
    }

    public int getLibid() {
        return libid;
    }

    public void setLibid(int libid) {
        this.libid = libid;
    }

    public String getLibname() {
        return libname;
    }

    public void setLibname(String libname) {
        this.libname = libname;
    }

    public String getLibcontact() {
        return libcontact;
    }

    public void setLibcontact(String libcontact) {
        this.libcontact = libcontact;
    }

    public String getLibaddress() {
        return libaddress;
    }

    public void setLibaddress(String libaddress) {
        this.libaddress = libaddress;
    }

    public String getLibcity() {
        return libcity;
    }

    public void setLibcity(String libcity) {
        this.libcity = libcity;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Rack> getRackList() {
        return rackList;
    }

    public void setRackList(List<Rack> rackList) {
        this.rackList = rackList;
    }

    @Override
    public String toString() {
        return "Library{" +
                "libid=" + libid +
                ", libname='" + libname + '\'' +
                ", libcontact='" + libcontact + '\'' +
                ", libaddress='" + libaddress + '\'' +
                ", libcity='" + libcity + '\'' +
                ", userList=" + userList +
                ", rackList=" + rackList +
                '}';
    }
}
