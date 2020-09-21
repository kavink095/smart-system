package com.bolton.project.smartlib.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rent")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rentid;
    private Date issuedate;
    private Date returndate;
    private int returnstatus;
    private int rackpositionstatus;

    @ManyToOne
    @JoinColumn(name = "bookrefid", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    public Rent() {
    }

    public Rent(Date issuedate, Date returndate, int returnstatus, int rackpositionstatus, Book book, User user) {
        this.issuedate = issuedate;
        this.returndate = returndate;
        this.returnstatus = returnstatus;
        this.rackpositionstatus = rackpositionstatus;
        this.book = book;
        this.user = user;
    }

    public int getRentid() {
        return rentid;
    }

    public void setRentid(int rentid) {
        this.rentid = rentid;
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public int getReturnstatus() {
        return returnstatus;
    }

    public void setReturnstatus(int returnstatus) {
        this.returnstatus = returnstatus;
    }

    public int getRackpositionstatus() {
        return rackpositionstatus;
    }

    public void setRackpositionstatus(int rackpositionstatus) {
        this.rackpositionstatus = rackpositionstatus;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "rentid=" + rentid +
                ", issuedate=" + issuedate +
                ", returndate=" + returndate +
                ", returnstatus=" + returnstatus +
                ", rackpositionstatus=" + rackpositionstatus +
                ", book=" + book +
                ", user=" + user +
                '}';
    }
}
