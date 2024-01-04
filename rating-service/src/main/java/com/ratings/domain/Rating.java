package com.ratings.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Rating {
    @Column(nullable = false)
    private String authorCode;

    @Column(length = 100, nullable = true)
    private String comment;

    @Column (nullable = false)
    private int score;

    public String getAuthorCode() {
        return authorCode;
    }

    public void setAuthorCode(String authorCode) {
        this.authorCode = authorCode;
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
}
