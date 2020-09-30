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

    @ManyToOne
    @JoinColumn(name = "celid", nullable = false)
    private Cell cell;

    @OneToMany(mappedBy = "rack")
    private List<Library> libraryList;

    @OneToMany(mappedBy = "rack")
    private List<Book> bookList;

    public Rack() {
    }

    public Rack(String rackid, String rackdesc, Library library, Cell cell) {
        this.rackid = rackid;
        this.rackdesc = rackdesc;
        this.library = library;
        this.cell = cell;
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

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public List<Library> getLibraryList() {
        return libraryList;
    }

    public void setLibraryList(List<Library> libraryList) {
        this.libraryList = libraryList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Rack{" +
                "rackid='" + rackid + '\'' +
                ", rackdesc='" + rackdesc + '\'' +
                ", library=" + library +
                ", cell=" + cell +
                ", libraryList=" + libraryList +
                ", bookList=" + bookList +
                '}';
    }
}
