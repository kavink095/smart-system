package com.bolton.project.smartlib.entity;

import com.bolton.project.smartlib.dto.BookDTO;
import com.bolton.project.smartlib.dto.RackDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cell")
public class Cell {

    @Id
    private String celid;
    private String celldesc;

    @OneToMany(mappedBy = "cell")
    private List<Rack> rackList;

    @ManyToOne()
    @JoinColumn(name = "bookrefid", nullable = false)
    private Book book;

    public Cell() {
    }

    public Cell(String celid, String celldesc, Book book) {
        this.celid = celid;
        this.celldesc = celldesc;
        this.book = book;
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

    public List<Rack> getRackList() {
        return rackList;
    }

    public void setRackList(List<Rack> rackList) {
        this.rackList = rackList;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "celid='" + celid + '\'' +
                ", celldesc='" + celldesc + '\'' +
                ", rackList=" + rackList +
                ", book=" + book +
                '}';
    }
}
