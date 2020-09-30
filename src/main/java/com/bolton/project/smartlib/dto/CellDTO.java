package com.bolton.project.smartlib.dto;

import java.util.List;

public class CellDTO {

    private String celid;
    private String celldesc;

    private RackDTO rackDTO;

    private List<BookDTO> bookDTOList;

    public CellDTO() {
    }

    public CellDTO(String celid, String celldesc, RackDTO rackDTO) {
        this.celid = celid;
        this.celldesc = celldesc;
        this.rackDTO = rackDTO;
    }

    public String getCelid() {
        return celid;
    }

    public void setCelid(String celid) {
        this.celid = celid;
    }

    public String getCelldesc() {
        return celldesc;
    }

    public void setCelldesc(String celldesc) {
        this.celldesc = celldesc;
    }

    public RackDTO getRackDTO() {
        return rackDTO;
    }

    public void setRackDTO(RackDTO rackDTO) {
        this.rackDTO = rackDTO;
    }

    public List<BookDTO> getBookDTOList() {
        return bookDTOList;
    }

    public void setBookDTOList(List<BookDTO> bookDTOList) {
        this.bookDTOList = bookDTOList;
    }

    @Override
    public String toString() {
        return "CellDTO{" +
                "celid='" + celid + '\'' +
                ", celldesc='" + celldesc + '\'' +
                ", rackDTO=" + rackDTO +
                ", bookDTOList=" + bookDTOList +
                '}';
    }
}
