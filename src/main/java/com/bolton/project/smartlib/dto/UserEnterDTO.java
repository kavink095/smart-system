package com.bolton.project.smartlib.dto;

import java.util.Date;

public class UserEnterDTO {

    private int enterid;
    private Date enterdate;
    private int enterstatus;

    private UserDTO userDTO;

    public UserEnterDTO() {
    }

    public UserEnterDTO(int enterid, Date enterdate, int enterstatus, UserDTO userDTO) {
        this.enterid = enterid;
        this.enterdate = enterdate;
        this.enterstatus = enterstatus;
        this.userDTO = userDTO;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "UserEnterDTO{" +
                "enterid=" + enterid +
                ", enterdate=" + enterdate +
                ", enterstatus=" + enterstatus +
                ", userDTO=" + userDTO +
                '}';
    }
}
