package com.bolton.project.smartlib.dto;

import java.util.Date;

public class UserBookDTO {

	private int userbookid;
	private Date txndate;
	private Date retdate;
	private int mark;
	private String rackmark;

	private String user;

	private String book;

	public UserBookDTO() {
	}

	public UserBookDTO(int userbookid, Date txndate, Date retdate, int mark, String rackmark, String user,
			String book) {
		super();
		this.userbookid = userbookid;
		this.txndate = txndate;
		this.retdate = retdate;
		this.mark = mark;
		this.rackmark = rackmark;
		this.user = user;
		this.book = book;
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

	public Date getRetdate() {
		return retdate;
	}

	public void setRetdate(Date retdate) {
		this.retdate = retdate;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getRackmark() {
		return rackmark;
	}

	public void setRackmark(String rackmark) {
		this.rackmark = rackmark;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "UserBookDTO [userbookid=" + userbookid + ", txndate=" + txndate + ", retdate=" + retdate + ", mark="
				+ mark + ", rackmark=" + rackmark + ", user=" + user + ", book=" + book + "]";
	}

	
}
