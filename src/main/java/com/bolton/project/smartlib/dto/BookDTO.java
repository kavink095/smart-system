package com.bolton.project.smartlib.dto;

import java.util.List;

public class BookDTO {

    private String bookrefid;
    private String bookcategory;
    private String bookname;
    private String bookisstatus;

    private RackDTO rackDTO;

    private List<RentDTO> rentDTOList;

    public BookDTO() {
    }

    public BookDTO(String bookrefid, String bookcategory, String bookname, String bookisstatus, RackDTO rackDTO) {
        this.bookrefid = bookrefid;
        this.bookcategory = bookcategory;
        this.bookname = bookname;
        this.bookisstatus = bookisstatus;
        this.rackDTO = rackDTO;
    }

    public String getBookrefid() {
        return bookrefid;
    }

    public void setBookrefid(String bookrefid) {
        this.bookrefid = bookrefid;
    }

    public String getBookcategory() {
        return bookcategory;
    }

    public void setBookcategory(String bookcategory) {
        this.bookcategory = bookcategory;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookisstatus() {
        return bookisstatus;
    }

    public void setBookisstatus(String bookisstatus) {
        this.bookisstatus = bookisstatus;
    }

    public RackDTO getRackDTO() {
        return rackDTO;
    }

    public void setRackDTO(RackDTO rackDTO) {
        this.rackDTO = rackDTO;
    }

    public List<RentDTO> getRentDTOList() {
        return rentDTOList;
    }

    public void setRentDTOList(List<RentDTO> rentDTOList) {
        this.rentDTOList = rentDTOList;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "bookrefid='" + bookrefid + '\'' +
                ", bookcategory='" + bookcategory + '\'' +
                ", bookname='" + bookname + '\'' +
                ", bookisstatus='" + bookisstatus + '\'' +
                ", rackDTO=" + rackDTO +
                ", rentDTOList=" + rentDTOList +
                '}';
    }
}
