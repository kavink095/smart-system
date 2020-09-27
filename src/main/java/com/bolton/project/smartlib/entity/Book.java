package com.bolton.project.smartlib.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "bookrefid")
    private String bookrefid;
    @Column(name = "bookcategory")
    private String bookcategory;
    @Column(name = "bookname")
    private String bookname;
    @Column(name = "bookisstatus")
    private String bookisstatus;

    @ManyToOne
    @JoinColumn(name = "rackid", nullable = false)
    private Rack rack;

    @OneToMany(mappedBy = "book")
    private List<Rent> rentList;

    @OneToMany(mappedBy = "book")
    private List<Cell> cellList;


    public Book() {
    }

}
