package com.bolton.project.smartlib.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "userbook")
public class UserRBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userbookid;
    private Date txndate;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "bookrefid", nullable = false)
    private Book book;

    public UserRBook() {
    }

    public UserRBook(Date txndate, User user, Book book) {
        this.txndate = txndate;
        this.user = user;
        this.book = book;
    }

    public int getUserbookid() {
        return userbookid;
    }

    public void setUserbookid(int userbookid) {
        this.userbookid = userbookid;
    }

    public Date getTxndate() {
        return txndate;
    }

    public void setTxndate(Date txndate) {
        this.txndate = txndate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "UserRBook{" +
                "userbookid=" + userbookid +
                ", txndate=" + txndate +
                ", user=" + user +
                ", book=" + book +
                '}';
    }
}
