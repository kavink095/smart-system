package com.bolton.project.smartlib.dto;

import java.util.List;

public class LibraryDTO {

    private int libid;
    private String libname;
    private String libcontact;
    private String libaddress;
    private String libcity;

    private UserDTO userDTO;

    private RackDTO rackDTO;

    public LibraryDTO() {
    }

    public LibraryDTO(int libid, String libname, String libcontact, String libaddress, String libcity, UserDTO userDTO, RackDTO rackDTO) {
        this.libid = libid;
        this.libname = libname;
        this.libcontact = libcontact;
        this.libaddress = libaddress;
        this.libcity = libcity;
        this.userDTO = userDTO;
        this.rackDTO = rackDTO;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public RackDTO getRackDTO() {
        return rackDTO;
    }

    public void setRackDTO(RackDTO rackDTO) {
        this.rackDTO = rackDTO;
    }

    @Override
    public String toString() {
        return "LibraryDTO{" +
                "libid=" + libid +
                ", libname='" + libname + '\'' +
                ", libcontact='" + libcontact + '\'' +
                ", libaddress='" + libaddress + '\'' +
                ", libcity='" + libcity + '\'' +
                ", userDTO=" + userDTO +
                ", rackDTO=" + rackDTO +
                '}';
    }
}
