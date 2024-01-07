package com.tours.domain;

import jakarta.persistence.*;

/**
 * Touristic tour attributes
 * */
@Entity
public class Tour {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String title;

    @Column (length=2000)
    private String description;

    @Column
    private Integer price;

    @Column
    private String duration;

    @Column
    private String offer;

    @ManyToOne
    private TourPackage tourPackage;

    @Column
    @Enumerated
    private Difficulty difficulty;

    @Column
    @Enumerated
    private Region region;

    public Tour(String title, String description, Integer price, String duration, String offer,
                TourPackage tourPackage, Difficulty difficulty, Region region) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.offer = offer;
        this.tourPackage = tourPackage;
        this.difficulty = difficulty;
        this.region = region;
    }

    protected Tour(){}

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public String getDuration() {
        return duration;
    }

    public String getOffer() {
        return offer;
    }

    public TourPackage getTourPackage() {
        return tourPackage;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Region getRegion() {
        return region;
    }
}
