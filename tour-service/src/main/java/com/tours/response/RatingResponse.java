package com.tours.response;

/**
 * Rating data retrieved as response from the request to the external service Ratings.
 */
public class RatingResponse {
    private String authorName;

    private String comment;

    private int score;

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
}
