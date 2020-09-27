package com.bolton.project.smartlib.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cell")
public class Cell {

    @Id
    private String celid;
    private String celldesc;

    @OneToMany(mappedBy = "cell")
    private List<Rack> rackList;

    @ManyToOne
    @JoinColumn(name = "bookrefid", nullable = false)
    private Book book;


}
