package com.bolton.project.smartlib.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {
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
    @Column(name = "userenteretatus")
    private String userenteretatus;
    @Column(name = "useractivestatus")
    private int useractivestatus;
    @ManyToOne
    @JoinColumn(name = "libid", nullable = false)
    private Library library;

    @OneToMany(mappedBy = "user")
    private List<UserRBook> userRBookList;

    public Users() {
    }

    public Users(String userid, String userfname, String userlname, String useraddress, String usermobile, String userenteretatus, int useractivestatus, Library library) {
        this.userid = userid;
        this.userfname = userfname;
        this.userlname = userlname;
        this.useraddress = useraddress;
        this.usermobile = usermobile;
        this.userenteretatus = userenteretatus;
        this.useractivestatus = useractivestatus;
        this.library = library;
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

    public String getUserenteretatus() {
        return userenteretatus;
    }

    public void setUserenteretatus(String userenteretatus) {
        this.userenteretatus = userenteretatus;
    }

    public int getUseractivestatus() {
        return useractivestatus;
    }

    public void setUseractivestatus(int useractivestatus) {
        this.useractivestatus = useractivestatus;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public List<UserRBook> getUserRBookList() {
        return userRBookList;
    }

    public void setUserRBookList(List<UserRBook> userRBookList) {
        this.userRBookList = userRBookList;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userid='" + userid + '\'' +
                ", userfname='" + userfname + '\'' +
                ", userlname='" + userlname + '\'' +
                ", useraddress='" + useraddress + '\'' +
                ", usermobile='" + usermobile + '\'' +
                ", userenteretatus='" + userenteretatus + '\'' +
                ", useractivestatus=" + useractivestatus +
                ", library=" + library +
                ", userRBookList=" + userRBookList +
                '}';
    }
}