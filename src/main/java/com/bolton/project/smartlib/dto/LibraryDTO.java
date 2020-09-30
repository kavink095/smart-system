package com.bolton.project.smartlib.dto;

import java.util.List;

public class LibraryDTO {

    private int libid;
    private String libname;
    private String libcontact;
    private String libaddress;
    private String libcity;

    private List<UserDTO> userDTOList;

    private List<RackDTO> rackDTOList;

    public LibraryDTO() {
    }

    public LibraryDTO(int libid, String libname, String libcontact, String libaddress, String libcity) {
        this.libid = libid;
        this.libname = libname;
        this.libcontact = libcontact;
        this.libaddress = libaddress;
        this.libcity = libcity;
    }

    public int getLibid() {
        return libid;
    }

    public void setLibid(int libid) {
        this.libid = libid;
    }

    public String getLibname() {
        return libname;
    }

    public void setLibname(String libname) {
        this.libname = libname;
    }

    public String getLibcontact() {
        return libcontact;
    }

    public void setLibcontact(String libcontact) {
        this.libcontact = libcontact;
    }

    public String getLibaddress() {
        return libaddress;
    }

    public void setLibaddress(String libaddress) {
        this.libaddress = libaddress;
    }

    public String getLibcity() {
        return libcity;
    }

    public void setLibcity(String libcity) {
        this.libcity = libcity;
    }

    public List<UserDTO> getUserDTOList() {
        return userDTOList;
    }

    public void setUserDTOList(List<UserDTO> userDTOList) {
        this.userDTOList = userDTOList;
    }

    public List<RackDTO> getRackDTOList() {
        return rackDTOList;
    }

    public void setRackDTOList(List<RackDTO> rackDTOList) {
        this.rackDTOList = rackDTOList;
    }

    @Override
    public String toString() {
        return "LibraryDTO{" +
                "libid=" + libid +
                ", libname='" + libname + '\'' +
                ", libcontact='" + libcontact + '\'' +
                ", libaddress='" + libaddress + '\'' +
                ", libcity='" + libcity + '\'' +
                ", userDTOList=" + userDTOList +
                ", rackDTOList=" + rackDTOList +
                '}';
    }
}
