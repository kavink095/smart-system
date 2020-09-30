package com.bolton.project.smartlib.entity;

import com.bolton.project.smartlib.dto.LibraryDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "userid")
    private String userid;
    @Column(name = "userfname")
    private String userfname;
    @Column(name = "userlname")
    private String userlname;
    @Column(name = "useraddress")
    private String useraddress;
    @Column(name = "usermobile")
    private String usermobile;
    @Column(name = "userEnterStatus")
    private String userEnterStatus;
    @Column(name = "useractivestatus")
    private int useractivestatus;

    @OneToMany(mappedBy = "user")
    private List<Library> libraryList;

    @OneToMany(mappedBy = "user")
    private List<Rent> rentList;


    public User() {
    }

    public User(String userid, String userfname, String userlname, String useraddress, String usermobile, String userEnterStatus, int useractivestatus) {
        this.userid = userid;
        this.userfname = userfname;
        this.userlname = userlname;
        this.useraddress = useraddress;
        this.usermobile = usermobile;
        this.userEnterStatus = userEnterStatus;
        this.useractivestatus = useractivestatus;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserfname() {
        return userfname;
    }

    public void setUserfname(String userfname) {
        this.userfname = userfname;
    }

    public String getUserlname() {
        return userlname;
    }

    public void setUserlname(String userlname) {
        this.userlname = userlname;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getUsermobile() {
        return usermobile;
    }

    public void setUsermobile(String usermobile) {
        this.usermobile = usermobile;
    }

    public String getUserEnterStatus() {
        return userEnterStatus;
    }

    public void setUserEnterStatus(String userEnterStatus) {
        this.userEnterStatus = userEnterStatus;
    }

    public int getUseractivestatus() {
        return useractivestatus;
    }

    public void setUseractivestatus(int useractivestatus) {
        this.useractivestatus = useractivestatus;
    }

    public List<Library> getLibraryList() {
        return libraryList;
    }

    public void setLibraryList(List<Library> libraryList) {
        this.libraryList = libraryList;
    }

    public List<Rent> getRentList() {
        return rentList;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", userfname='" + userfname + '\'' +
                ", userlname='" + userlname + '\'' +
                ", useraddress='" + useraddress + '\'' +
                ", usermobile='" + usermobile + '\'' +
                ", userEnterStatus='" + userEnterStatus + '\'' +
                ", useractivestatus=" + useractivestatus +
                ", libraryList=" + libraryList +
                ", rentList=" + rentList +
                '}';
    }
}
