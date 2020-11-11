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

    private Date retdate;

    private int mark;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)

    private int rackmark;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "userid", nullable = false)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "bookrefid", nullable = false)
    private Book book;

    public UserRBook() {
    }

    public UserRBook(Date txndate, Date retdate, int mark, int rackmark, Users user, Book book) {
        this.txndate = txndate;
        this.retdate = retdate;
        this.mark = mark;
        this.rackmark = rackmark;
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

    public Date getRetdate() {
        return retdate;
    }

    public void setRetdate(Date retdate) {
        this.retdate = retdate;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getRackmark() {
        return rackmark;
    }

    public void setRackmark(int rackmark) {
        this.rackmark = rackmark;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
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
                ", retdate=" + retdate +
                ", mark=" + mark +
                ", rackmark=" + rackmark +
                ", user=" + user +
                ", book=" + book +
                '}';
    }
}
