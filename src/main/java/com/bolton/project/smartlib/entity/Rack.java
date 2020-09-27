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


}
