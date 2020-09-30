package com.bolton.project.smartlib.dto;

import java.util.List;

public class UserDTO {

    private String userid;
    private String userfname;
    private String userlname;
    private String useraddress;
    private String usermobile;
    private int useractivestatus;

    private LibraryDTO libraryDTO;

    private List<RentDTO> rentDTOList;

    public UserDTO() {
    }

    public UserDTO(String userid, String userfname, String userlname, String useraddress, String usermobile, int useractivestatus, LibraryDTO libraryDTO, List<RentDTO> rentDTOList) {
        this.userid = userid;
        this.userfname = userfname;
        this.userlname = userlname;
        this.useraddress = useraddress;
        this.usermobile = usermobile;
        this.useractivestatus = useractivestatus;
        this.libraryDTO = libraryDTO;
        this.rentDTOList = rentDTOList;
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

    public int getUseractivestatus() {
        return useractivestatus;
    }

    public void setUseractivestatus(int useractivestatus) {
        this.useractivestatus = useractivestatus;
    }

    public LibraryDTO getLibraryDTO() {
        return libraryDTO;
    }

    public void setLibraryDTO(LibraryDTO libraryDTO) {
        this.libraryDTO = libraryDTO;
    }

    public List<RentDTO> getRentDTOList() {
        return rentDTOList;
    }

    public void setRentDTOList(List<RentDTO> rentDTOList) {
        this.rentDTOList = rentDTOList;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userid='" + userid + '\'' +
                ", userfname='" + userfname + '\'' +
                ", userlname='" + userlname + '\'' +
                ", useraddress='" + useraddress + '\'' +
                ", usermobile='" + usermobile + '\'' +
                ", useractivestatus=" + useractivestatus +
                ", libraryDTO=" + libraryDTO +
                ", rentDTOList=" + rentDTOList +
                '}';
    }
}
