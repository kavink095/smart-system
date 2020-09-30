package com.bolton.project.smartlib.dto;

import java.util.Date;

public class UserBookDTO {

    private int userbookid;
    private Date txndate;

    private UserDTO userDTO;

    private BookDTO bookDTO;

    public UserBookDTO() {
    }

    public UserBookDTO(int userbookid, Date txndate, UserDTO userDTO, BookDTO bookDTO) {
        this.userbookid = userbookid;
        this.txndate = txndate;
        this.userDTO = userDTO;
        this.bookDTO = bookDTO;
    }

    public int getUserbookid() {
        return userbookid;
    }

    public void setUserbookid(int userbookid) {
        this.userbookid = userbookid;
    }

    public Date getTxndate() {
        return txndate;
    }

    public void setTxndate(Date txndate) {
        this.txndate = txndate;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }

    @Override
    public String toString() {
        return "UserBookDTO{" +
                "userbookid=" + userbookid +
                ", txndate=" + txndate +
                ", userDTO=" + userDTO +
                ", bookDTO=" + bookDTO +
                '}';
    }
}
