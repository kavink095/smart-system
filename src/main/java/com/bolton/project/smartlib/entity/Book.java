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
	@Column(name = "booknowsts")
	private String booknowsts;

	@ManyToOne()
	@JoinColumn(name = "racid", nullable = false)
	private Rack rackid;

	@OneToMany(mappedBy = "user")
	private List<UserRBook> userRBookList;

	public Book() {
	}

	public Book(String bookrefid, String bookname, String bookwriter, String bookdesc, String bookisstatus,
			String booknowsts, Rack rackid) {
		super();
		this.bookrefid = bookrefid;
		this.bookname = bookname;
		this.bookwriter = bookwriter;
		this.bookdesc = bookdesc;
		this.bookisstatus = bookisstatus;
		this.booknowsts = booknowsts;
		this.rackid = rackid;
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

	public String getBooknowsts() {
		return booknowsts;
	}

	public void setBooknowsts(String booknowsts) {
		this.booknowsts = booknowsts;
	}

	public Rack getRackid() {
		return rackid;
	}

	public void setRackid(Rack rackid) {
		this.rackid = rackid;
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
				+ bookdesc + ", bookisstatus=" + bookisstatus + ", booknowsts=" + booknowsts
				+ ", userRBookList=" + userRBookList + "]";
	}

	

	
}
