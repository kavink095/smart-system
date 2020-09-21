package com.bolton.project.smartlib.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "userenter")
public class UserEnter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int enterid;
    private Date enterdate;
    private int enterstatus;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    public UserEnter() {
    }

    public UserEnter(Date enterdate, int enterstatus, User user) {
        this.enterdate = enterdate;
        this.enterstatus = enterstatus;
        this.user = user;
    }

    public int getEnterid() {
        return enterid;
    }

    public void setEnterid(int enterid) {
        this.enterid = enterid;
    }

    public Date getEnterdate() {
        return enterdate;
    }

    public void setEnterdate(Date enterdate) {
        this.enterdate = enterdate;
    }

    public int getEnterstatus() {
        return enterstatus;
    }

    public void setEnterstatus(int enterstatus) {
        this.enterstatus = enterstatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserEnter{" +
                "enterid=" + enterid +
                ", enterdate=" + enterdate +
                ", enterstatus=" + enterstatus +
                ", user=" + user +
                '}';
    }
}
