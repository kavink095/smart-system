package com.bolton.project.smartlib.dto;

import java.util.List;

public class RackDTO {

    private String racid;
    private String rackdesc;

    private List<BookDTO> bookDTOList;

    public RackDTO() {
    }

	public RackDTO(String racid, String rackdesc) {
		super();
		this.racid = racid;
		this.rackdesc = rackdesc;
	}

	public String getRacid() {
		return racid;
	}

	public void setRackid(String racid) {
		this.racid = racid;
	}

	public String getRackdesc() {
		return rackdesc;
	}

	public void setRackdesc(String rackdesc) {
		this.rackdesc = rackdesc;
	}

	public List<BookDTO> getBookDTOList() {
		return bookDTOList;
	}

	public void setBookDTOList(List<BookDTO> bookDTOList) {
		this.bookDTOList = bookDTOList;
	}

	@Override
	public String toString() {
		return "RackDTO [rackid=" + racid + ", rackdesc=" + rackdesc + ", bookDTOList=" + bookDTOList + "]";
	}

   
}
