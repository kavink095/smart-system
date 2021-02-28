package com.bolton.project.smartlib.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rack")
public class Rack {

	@Id
	@Column(name = "racid", updatable = false)
	private String racid;
	private String rackdesc;

//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "book")
//	private List<Book> bookList;

	public Rack() {
	}

	public Rack(String racid, String rackdesc) {
		super();
		this.racid = racid;
		this.rackdesc = rackdesc;
	}

	public String getRacid() {
		return racid;
	}

	public void setRacid(String racid) {
		this.racid = racid;
	}

	public String getRackdesc() {
		return rackdesc;
	}

	public void setRackdesc(String rackdesc) {
		this.rackdesc = rackdesc;
	}
//
//	public List<Book> getBookList() {
//		return bookList;
//	}
//
//	public void setBookList(List<Book> bookList) {
//		this.bookList = bookList;
//	}

//	@Override
//	public String toString() {
//		return "Rack [rackid=" + racid + ", rackdesc=" + rackdesc + ", bookList=" + bookList + "]";
//	}

}
