package com.bolton.project.smartlib.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cell")
public class Cell {

    @Id
    private String celid;
    private String celldesc;

    @ManyToOne
    @JoinColumn(name = "rackid", nullable = false)
    private Rack rack;

    @OneToMany(mappedBy = "cell")
    private List<Book> bookList;

    public Cell() {
    }

    public Cell(String celid, String celldesc, Rack rack) {
        this.celid = celid;
        this.celldesc = celldesc;
        this.rack = rack;
    }

    public String getCelid() {
        return celid;
    }

    public void setCelid(String celid) {
        this.celid = celid;
    }

    public String getCelldesc() {
        return celldesc;
    }

    public void setCelldesc(String celldesc) {
        this.celldesc = celldesc;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "celid='" + celid + '\'' +
                ", celldesc='" + celldesc + '\'' +
                ", rack=" + rack +
                ", bookList=" + bookList +
                '}';
    }
}
