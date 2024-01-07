package com.tours.response;

import com.tours.domain.Difficulty;
import java.util.List;

/**
 * Tour data incorporating fields from internal API and Rating Response from external service.
 */
public class TourResponse {

    private String title;

    private String offer;

    private Integer price;

    private String duration;

    private Difficulty difficulty;
    private List<RatingResponse> ratingResponse;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<RatingResponse> getRatingResponse() {
        return ratingResponse;
    }

    public void setRatingResponse(List<RatingResponse> ratingResponse) {
        this.ratingResponse = ratingResponse;
    }
}
