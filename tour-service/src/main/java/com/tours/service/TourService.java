package com.tours.service;

import com.tours.domain.Difficulty;
import com.tours.domain.Region;
import com.tours.domain.Tour;
import com.tours.domain.TourPackage;
import com.tours.repository.TourPackageRepository;
import com.tours.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {

    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title, String description, Integer price, String duration, String offer,
                           String tourPackageName, Difficulty difficulty, Region region){

        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName)
                .orElseThrow(() -> new RuntimeException("Tour package does not exist!" + tourPackageName));

        return tourRepository.save(new Tour(title, description, price, duration, offer, tourPackage, difficulty, region));
    }

    public long countTours() {
        return tourRepository.count();
    }
}
