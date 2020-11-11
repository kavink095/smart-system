package com.bolton.project.smartlib.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rack")
public class Rack {
    @Id
    @Column(name = "rackid")
    private String rackid;
    @Column(name = "rackdesc")
    private String rackdesc;

    @ManyToOne
    @JoinColumn(name = "libid", nullable = false)
    private Library library;

    @OneToMany(mappedBy = "rack")
    private List<Cell> cellList;

    public Rack() {
    }

    public Rack(String rackid, String rackdesc, Library library) {
        this.rackid = rackid;
        this.rackdesc = rackdesc;
        this.library = library;
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

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public List<Cell> getCellList() {
        return cellList;
    }

    public void setCellList(List<Cell> cellList) {
        this.cellList = cellList;
    }

    @Override
    public String toString() {
        return "Rack{" +
                "rackid='" + rackid + '\'' +
                ", rackdesc='" + rackdesc + '\'' +
                ", cellList=" + cellList +
                '}';
    }
}
