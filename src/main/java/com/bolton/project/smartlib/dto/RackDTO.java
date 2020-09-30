package com.bolton.project.smartlib.dto;

import java.util.List;

public class RackDTO {

    private String rackid;
    private String rackdesc;

    private LibraryDTO libraryDTO;

    private CellDTO cellDTO;

    private List<LibraryDTO> libraryDTOList;

    private List<BookDTO> bookDTOList;

    public RackDTO() {
    }

    public RackDTO(String rackid, String rackdesc, LibraryDTO libraryDTO, CellDTO cellDTO) {
        this.rackid = rackid;
        this.rackdesc = rackdesc;
        this.libraryDTO = libraryDTO;
        this.cellDTO = cellDTO;
    }

    public String getRackid() {
        return rackid;
    }

    public void setRackid(String rackid) {
        this.rackid = rackid;
    }

    public String getRackdesc() {
        return rackdesc;
    }

    public void setRackdesc(String rackdesc) {
        this.rackdesc = rackdesc;
    }

    public LibraryDTO getLibraryDTO() {
        return libraryDTO;
    }

    public void setLibraryDTO(LibraryDTO libraryDTO) {
        this.libraryDTO = libraryDTO;
    }

    public CellDTO getCellDTO() {
        return cellDTO;
    }

    public void setCellDTO(CellDTO cellDTO) {
        this.cellDTO = cellDTO;
    }

    public List<LibraryDTO> getLibraryDTOList() {
        return libraryDTOList;
    }

    public void setLibraryDTOList(List<LibraryDTO> libraryDTOList) {
        this.libraryDTOList = libraryDTOList;
    }

    public List<BookDTO> getBookDTOList() {
        return bookDTOList;
    }

    public void setBookDTOList(List<BookDTO> bookDTOList) {
        this.bookDTOList = bookDTOList;
    }

    @Override
    public String toString() {
        return "RackDTO{" +
                "rackid='" + rackid + '\'' +
                ", rackdesc='" + rackdesc + '\'' +
                ", libraryDTO=" + libraryDTO +
                ", cellDTO=" + cellDTO +
                ", libraryDTOList=" + libraryDTOList +
                ", bookDTOList=" + bookDTOList +
                '}';
    }
}
