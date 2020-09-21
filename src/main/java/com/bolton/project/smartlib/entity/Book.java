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

    public Book() {
    }

    public Book(String bookrefid, String bookcategory, String bookname, String bookisstatus, Rack rack) {
        this.bookrefid = bookrefid;
        this.bookcategory = bookcategory;
        this.bookname = bookname;
        this.bookisstatus = bookisstatus;
        this.rack = rack;
    }

    public String getBookrefid() {
        return bookrefid;
    }

    public void setBookrefid(String bookrefid) {
        this.bookrefid = bookrefid;
    }

    public String getBookcategory() {
        return bookcategory;
    }

    public void setBookcategory(String bookcategory) {
        this.bookcategory = bookcategory;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookisstatus() {
        return bookisstatus;
    }

    public void setBookisstatus(String bookisstatus) {
        this.bookisstatus = bookisstatus;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public List<Rent> getRentList() {
        return rentList;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookrefid='" + bookrefid + '\'' +
                ", bookcategory='" + bookcategory + '\'' +
                ", bookname='" + bookname + '\'' +
                ", bookisstatus='" + bookisstatus + '\'' +
                ", rack=" + rack +
                ", rentList=" + rentList +
                '}';
    }
}
