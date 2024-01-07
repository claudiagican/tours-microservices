package com.tours.controller;

import com.tours.domain.Tour;
import com.tours.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
/**
 * Tour Controller for the microservice internal REST API
 * */
@RequestMapping(path = "/tours")
public class TourController {

    private TourRepository tourRepository;

    @Autowired
    public TourController(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public TourController() {
    }

    @GetMapping
    public List<Tour> getTours(){
        return tourRepository.findAll();
    }
}
