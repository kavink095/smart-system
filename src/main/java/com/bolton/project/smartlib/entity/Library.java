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
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "rackid", nullable = false)
    private Rack rack;

    public Library() {
    }

    public Library(int libid, String libname, String libcontact, String libaddress, String libcity, User user, Rack rack) {
        this.libid = libid;
        this.libname = libname;
        this.libcontact = libcontact;
        this.libaddress = libaddress;
        this.libcity = libcity;
        this.user = user;
        this.rack = rack;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    @Override
    public String toString() {
        return "Library{" +
                "libid=" + libid +
                ", libname='" + libname + '\'' +
                ", libcontact='" + libcontact + '\'' +
                ", libaddress='" + libaddress + '\'' +
                ", libcity='" + libcity + '\'' +
                ", user=" + user +
                ", rack=" + rack +
                '}';
    }
}
