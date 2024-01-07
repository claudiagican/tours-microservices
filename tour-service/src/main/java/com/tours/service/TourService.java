package com.tours.service;

import com.tours.response.RatingResponse;
import org.modelmapper.ModelMapper;
import com.tours.domain.Difficulty;
import com.tours.domain.Region;
import com.tours.domain.Tour;
import com.tours.domain.TourPackage;
import com.tours.feignclient.RatingClient;
import com.tours.repository.TourPackageRepository;
import com.tours.repository.TourRepository;
import com.tours.response.TourResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourService {

    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }
    @Autowired (required = true)
    private RatingClient ratingClient;

    @Autowired
    private ModelMapper mapper;

    public TourResponse getTourRatingsById(Integer tourId){
        Optional<Tour> tour = tourRepository.findById(tourId);
        TourResponse toursResponse = mapper.map(tour, TourResponse.class);

        List<RatingResponse> ratingResponse = ratingClient.getRatingsByTourId(tourId);
        toursResponse.setRatingResponse(ratingResponse);

        return toursResponse;
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
