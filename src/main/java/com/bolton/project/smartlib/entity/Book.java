package com.bolton.project.smartlib.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@Column(name = "bookrefid", updatable = false)
	private String bookrefid;
	@Column(name = "bookname")
	private String bookname;
	@Column(name = "bookwriter")
	private String bookwriter;
	@Column(name = "bookdesc")
	private String bookdesc;
	@Column(name = "bookisstatus")
	private String bookisstatus;

	@ManyToOne()
	@JoinColumn(name = "racid", nullable = false)
	private Rack cell;

	@OneToMany(mappedBy = "user")
	private List<UserRBook> userRBookList;

	public Book() {
	}

	public Book(String bookrefid, String bookname, String bookwriter, String bookdesc, String bookisstatus, Rack cell) {
		super();
		this.bookrefid = bookrefid;
		this.bookname = bookname;
		this.bookwriter = bookwriter;
		this.bookdesc = bookdesc;
		this.bookisstatus = bookisstatus;
		this.cell = cell;
	}

	public String getBookrefid() {
		return bookrefid;
	}

	public void setBookrefid(String bookrefid) {
		this.bookrefid = bookrefid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookwriter() {
		return bookwriter;
	}

	public void setBookwriter(String bookwriter) {
		this.bookwriter = bookwriter;
	}

	public String getBookdesc() {
		return bookdesc;
	}

	public void setBookdesc(String bookdesc) {
		this.bookdesc = bookdesc;
	}

	public String getBookisstatus() {
		return bookisstatus;
	}

	public void setBookisstatus(String bookisstatus) {
		this.bookisstatus = bookisstatus;
	}

	public Rack getCell() {
		return cell;
	}

	public void setCell(Rack cell) {
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
		return "Book [bookrefid=" + bookrefid + ", bookname=" + bookname + ", bookwriter=" + bookwriter + ", bookdesc="
				+ bookdesc + ", bookisstatus=" + bookisstatus + ", cell=" + cell + ", userRBookList=" + userRBookList
				+ "]";
	}

}
