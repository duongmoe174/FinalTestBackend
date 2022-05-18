package com.duong.finaltest.model;

import javax.persistence.*;

@Entity
@Table (name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country(String name) {
        this.name = name;
    }

    public Country() {
    }

    public Country(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
