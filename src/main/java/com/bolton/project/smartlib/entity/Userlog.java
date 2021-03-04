package com.bolton.project.smartlib.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "userlog")
public class Userlog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int logid;
    private String userid;
    private int mark;
    private Date enterdate;
    private Time entertime;
    private Time exittime;

    public Userlog() {
    }

    public Userlog(String userid, int mark, Date enterdate, Time entertime, Time exittime) {
        this.userid = userid;
        this.mark = mark;
        this.enterdate = enterdate;
        this.entertime = entertime;
        this.exittime = exittime;
    }

    public int getLogid() {
        return logid;
    }

    public void setLogid(int logid) {
        this.logid = logid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Date getEnterdate() {
        return enterdate;
    }

    public void setEnterdate(Date enterdate) {
        this.enterdate = enterdate;
    }

    public Time getEntertime() {
        return entertime;
    }

    public void setEntertime(Time entertime) {
        this.entertime = entertime;
    }

    public Time getExittime() {
        return exittime;
    }

    public void setExittime(Time exittime) {
        this.exittime = exittime;
    }

    @Override
    public String toString() {
        return "Userlog{" +
                "logid=" + logid +
                ", userid='" + userid + '\'' +
                ", mark=" + mark +
                ", enterdate=" + enterdate +
                ", entertime=" + entertime +
                ", exittime=" + exittime +
                '}';
    }
}
