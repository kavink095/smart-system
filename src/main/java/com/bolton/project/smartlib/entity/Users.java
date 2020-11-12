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
    @Column(name = "usermail")
    private String usermail;
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
    @Column(name = "userpassword")
    private String userpassword;
    @Column(name = "gender")
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libid", nullable = false)
    private Library library;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<UserRBook> userRBookList;

    public Users() {
    }

    public Users(String userid, String userfname, String usermail, String userlname, String useraddress, String usermobile, String userenteretatus, int useractivestatus, String userpassword, String gender, Library library) {
        this.userid = userid;
        this.userfname = userfname;
        this.usermail = usermail;
        this.userlname = userlname;
        this.useraddress = useraddress;
        this.usermobile = usermobile;
        this.userenteretatus = userenteretatus;
        this.useractivestatus = useractivestatus;
        this.userpassword = userpassword;
        this.gender = gender;
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

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
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

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
                ", usermail='" + usermail + '\'' +
                ", userlname='" + userlname + '\'' +
                ", useraddress='" + useraddress + '\'' +
                ", usermobile='" + usermobile + '\'' +
                ", userenteretatus='" + userenteretatus + '\'' +
                ", useractivestatus=" + useractivestatus +
                ", userpassword='" + userpassword + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
