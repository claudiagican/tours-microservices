package com.ratings.service;

import com.ratings.repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Rating service
 * */
@Service
public class RatingsService {

    private RatingsRepository ratingsRepository;

    @Autowired
    public RatingsService(RatingsRepository ratingsRepository) {
        this.ratingsRepository = ratingsRepository;
    }
}
