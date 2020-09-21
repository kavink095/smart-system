package com.bolton.project.smartlib.dto;

import java.util.Date;

public class RentDTO {

    private int rentid;
    private Date issuedate;
    private Date returndate;
    private int returnstatus;
    private int rackpositionstatus;

    private BookDTO bookDTO;

    private UserDTO userDTO;

    public RentDTO() {
    }

    public RentDTO(int rentid, Date issuedate, Date returndate, int returnstatus, int rackpositionstatus, BookDTO bookDTO, UserDTO userDTO) {
        this.rentid = rentid;
        this.issuedate = issuedate;
        this.returndate = returndate;
        this.returnstatus = returnstatus;
        this.rackpositionstatus = rackpositionstatus;
        this.bookDTO = bookDTO;
        this.userDTO = userDTO;
    }

    public int getRentid() {
        return rentid;
    }

    public void setRentid(int rentid) {
        this.rentid = rentid;
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public int getReturnstatus() {
        return returnstatus;
    }

    public void setReturnstatus(int returnstatus) {
        this.returnstatus = returnstatus;
    }

    public int getRackpositionstatus() {
        return rackpositionstatus;
    }

    public void setRackpositionstatus(int rackpositionstatus) {
        this.rackpositionstatus = rackpositionstatus;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "RentDTO{" +
                "rentid=" + rentid +
                ", issuedate=" + issuedate +
                ", returndate=" + returndate +
                ", returnstatus=" + returnstatus +
                ", rackpositionstatus=" + rackpositionstatus +
                ", bookDTO=" + bookDTO +
                ", userDTO=" + userDTO +
                '}';
    }
}
