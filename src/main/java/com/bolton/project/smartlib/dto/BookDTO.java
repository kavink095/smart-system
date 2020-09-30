package com.bolton.project.smartlib.dto;

import java.util.List;

public class BookDTO {

    private String bookrefid;
    private String bookcategory;
    private String bookname;
    private String bookisstatus;

    private CellDTO cellDTO;

    private List<UserBookDTO> userBookDTOList;

    public BookDTO() {
    }

    public BookDTO(String bookrefid, String bookcategory, String bookname, String bookisstatus, CellDTO cellDTO) {
        this.bookrefid = bookrefid;
        this.bookcategory = bookcategory;
        this.bookname = bookname;
        this.bookisstatus = bookisstatus;
        this.cellDTO = cellDTO;
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

    public CellDTO getCellDTO() {
        return cellDTO;
    }

    public void setCellDTO(CellDTO cellDTO) {
        this.cellDTO = cellDTO;
    }

    public List<UserBookDTO> getUserBookDTOList() {
        return userBookDTOList;
    }

    public void setUserBookDTOList(List<UserBookDTO> userBookDTOList) {
        this.userBookDTOList = userBookDTOList;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "bookrefid='" + bookrefid + '\'' +
                ", bookcategory='" + bookcategory + '\'' +
                ", bookname='" + bookname + '\'' +
                ", bookisstatus='" + bookisstatus + '\'' +
                ", cellDTO=" + cellDTO +
                ", userBookDTOList=" + userBookDTOList +
                '}';
    }
}
