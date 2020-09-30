package com.bolton.project.smartlib.dto;

import java.util.List;

public class RackDTO {

    private String rackid;
    private String rackdesc;

    private LibraryDTO libraryDTO;

    private List<CellDTO> cellDTOList;

    public RackDTO() {
    }

    public RackDTO(String rackid, String rackdesc, LibraryDTO libraryDTO) {
        this.rackid = rackid;
        this.rackdesc = rackdesc;
        this.libraryDTO = libraryDTO;
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

    public List<CellDTO> getCellDTOList() {
        return cellDTOList;
    }

    public void setCellDTOList(List<CellDTO> cellDTOList) {
        this.cellDTOList = cellDTOList;
    }

    @Override
    public String toString() {
        return "RackDTO{" +
                "rackid='" + rackid + '\'' +
                ", rackdesc='" + rackdesc + '\'' +
                ", libraryDTO=" + libraryDTO +
                ", cellDTOList=" + cellDTOList +
                '}';
    }
}
