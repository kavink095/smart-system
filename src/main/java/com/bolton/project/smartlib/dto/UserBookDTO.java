package com.bolton.project.smartlib.dto;

import com.bolton.project.smartlib.entity.Rack;

import java.util.Date;

public class UserBookDTO {

	private int userbookid;
	private Date txndate;
	private Date retdate;
	private int mark;
	private String rackmark;

	private String userid;

	private String bookrefid;


	public UserBookDTO() {
	}

	public UserBookDTO(int userbookid, Date txndate, Date retdate, int mark, String rackmark, String userid, String bookrefid) {
		this.userbookid = userbookid;
		this.txndate = txndate;
		this.retdate = retdate;
		this.mark = mark;
		this.rackmark = rackmark;
		this.userid = userid;
		this.bookrefid = bookrefid;
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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getBookrefid() {
		return bookrefid;
	}

	public void setBookrefid(String bookrefid) {
		this.bookrefid = bookrefid;
	}

	@Override
	public String toString() {
		return "UserBookDTO [userbookid=" + userbookid + ", txndate=" + txndate + ", retdate=" + retdate + ", mark="
				+ mark + ", rackmark=" + rackmark + ", userid=" + userid + ", bookrefid=" + bookrefid + "]";
	}

	
	
}
