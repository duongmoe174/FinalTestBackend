package com.duong.finaltest.model;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Country country;
    private double acreage;
    private double population;
    private double gdp;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public double getAcreage() {
        return acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getGdp() {
        return gdp;
    }

    public void setGdp(double gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City(String name, Country country, double acreage, double population, double gdp, String description) {
        this.name = name;
        this.country = country;
        this.acreage = acreage;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }

    public City(Long id, String name, Country country, double acreage, double population, double gdp, String description) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.acreage = acreage;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }

    public City() {
    }
}
