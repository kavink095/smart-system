package com.bolton.project.smartlib.dto;

import java.util.List;

import javax.persistence.Column;

import com.bolton.project.smartlib.entity.Rack;
import com.bolton.project.smartlib.entity.UserRBook;

public class BookDTO {

	private String bookrefid;
	private String bookname;
	private String bookwriter;
	private String bookdesc;
	private String bookisstatus;
	private String booknowsts;

	private String rackid;

	private List<UserBookDTO> userBookDTOList;

	public BookDTO() {
	}

	public BookDTO(String bookrefid, String bookname, String bookwriter, String bookdesc, String bookisstatus,
			String booknowsts, String rackid) {
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

	public String getRackid() {
		return rackid;
	}

	public void setRackid(String rackid) {
		this.rackid = rackid;
	}

	public List<UserBookDTO> getUserBookDTOList() {
		return userBookDTOList;
	}

	public void setUserBookDTOList(List<UserBookDTO> userBookDTOList) {
		this.userBookDTOList = userBookDTOList;
	}

	@Override
	public String toString() {
		return "BookDTO [bookrefid=" + bookrefid + ", bookname=" + bookname + ", bookwriter=" + bookwriter
				+ ", bookdesc=" + bookdesc + ", bookisstatus=" + bookisstatus + ", booknowsts=" + booknowsts
				+ ", rackid=" + rackid + ", userBookDTOList=" + userBookDTOList + "]";
	}

}
