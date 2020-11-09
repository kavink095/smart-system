package com.bolton.project.smartlib.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "bookrefid", updatable = false)
    private String bookrefid;
    @Column(name = "bookcategory")
    private String bookcategory;
    @Column(name = "bookname")
    private String bookname;
    @Column(name = "bookisstatus")
    private String bookisstatus;

    @ManyToOne()
    @JoinColumn(name = "celid", nullable = false)
    private Cell cell;

    @OneToMany(mappedBy = "user")
    private List<UserRBook> userRBookList;

    public Book() {
    }

    public Book(String bookrefid, String bookcategory, String bookname, String bookisstatus, Cell cell) {
        this.bookrefid = bookrefid;
        this.bookcategory = bookcategory;
        this.bookname = bookname;
        this.bookisstatus = bookisstatus;
        this.cell = cell;
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

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public List<UserRBook> getUserRBookList() {
        return userRBookList;
    }

    public void setUserRBookList(List<UserRBook> userRBookList) {
        this.userRBookList = userRBookList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookrefid='" + bookrefid + '\'' +
                ", bookcategory='" + bookcategory + '\'' +
                ", bookname='" + bookname + '\'' +
                ", bookisstatus='" + bookisstatus + '\'' +
                ", userRBookList=" + userRBookList +
                '}';
    }
}
