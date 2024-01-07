package com.ratings.controller;

import com.ratings.domain.Rating;
import com.ratings.repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 *  Rating Controller
 * */
@RestController
@RequestMapping("/ratings")
public class RatingsController {

    private RatingsRepository ratingsRepository;

    @Autowired
    public RatingsController(RatingsRepository ratingsRepository) {
        this.ratingsRepository = ratingsRepository;
    }

    @GetMapping("tours/tourId/{tourId}")
    public List<Rating> getRatingsByTourId(@PathVariable(value = "tourId") Integer tourId){
        return ratingsRepository.findByTourId(tourId);
    }
}
