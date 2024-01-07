package com.ratings.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Rating {
    @Id
    @GeneratedValue
    private Integer ratingId;

    @Column(nullable = false)
    private int tourId;

    @Column(nullable = false)
    private String authorName;

    @Column(length = 100, nullable = true)
    private String comment;

    @Column (nullable = false)
    private int score;

    public Rating(int tourId, String authorName, String comment, int score) {
        this.tourId = tourId;
        this.authorName = authorName;
        this.comment = comment;
        this.score = score;
    }

    protected Rating() {
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }
}
