package com.bolton.project.smartlib.dto;

import java.util.List;

public class UserDTO {

    private String userid;
    private String userfname;
    private String usermail;
    private String userlname;
    private String useraddress;
    private String usermobile;
    private String userenteretatus;
    private int useractivestatus;
    private String userpassword;
    private String gender;

    private int libraryDTO;

    private List<UserBookDTO> userBookDTOList;

    public UserDTO() {
    }

    public UserDTO(String userid, String userfname, String usermail, String userlname, String useraddress, String usermobile, String userenteretatus, int useractivestatus, String userpassword, String gender, int libraryDTO) {
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
        this.libraryDTO = libraryDTO;
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

    public int getLibraryDTO() {
        return libraryDTO;
    }

    public void setLibraryDTO(int libraryDTO) {
        this.libraryDTO = libraryDTO;
    }

    public List<UserBookDTO> getUserBookDTOList() {
        return userBookDTOList;
    }

    public void setUserBookDTOList(List<UserBookDTO> userBookDTOList) {
        this.userBookDTOList = userBookDTOList;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
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
                ", libraryDTO=" + libraryDTO +
                ", userBookDTOList=" + userBookDTOList +
                '}';
    }
}
