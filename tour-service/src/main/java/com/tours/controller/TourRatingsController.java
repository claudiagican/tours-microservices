package com.tours.controller;

import com.tours.response.TourResponse;
import com.tours.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Tour Rating Controller dedicated to the external rating request
 * */
@RestController
public class TourRatingsController {

    @Autowired
    private TourService tourService;

    @GetMapping("/tours/{tourId}/ratings")
    public TourResponse getTourRatingsById(@PathVariable("tourId") Integer tourId){
        return tourService.getTourRatingsById(tourId);
    }
}
