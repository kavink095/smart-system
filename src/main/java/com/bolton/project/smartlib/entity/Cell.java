package com.bolton.project.smartlib.entity;

import com.bolton.project.smartlib.dto.BookDTO;
import com.bolton.project.smartlib.dto.RackDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cell")
public class Cell {

    @Id
    private String celid;
    private String celldesc;

    private List<RackDTO> rackDTOList;

    private BookDTO bookDTO;

    public Cell() {
    }

    public Cell(String celid, String celldesc, BookDTO bookDTO) {
        this.celid = celid;
        this.celldesc = celldesc;
        this.bookDTO = bookDTO;
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

    public List<RackDTO> getRackDTOList() {
        return rackDTOList;
    }

    public void setRackDTOList(List<RackDTO> rackDTOList) {
        this.rackDTOList = rackDTOList;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "celid='" + celid + '\'' +
                ", celldesc='" + celldesc + '\'' +
                ", rackDTOList=" + rackDTOList +
                ", bookDTO=" + bookDTO +
                '}';
    }
}
