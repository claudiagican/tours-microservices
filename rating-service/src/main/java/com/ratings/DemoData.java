package com.ratings;

import com.ratings.domain.Rating;
import com.ratings.repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Create demo data (in Rating table) after Spring boot app starts.
 * */
@Component
public class DemoData {

    @Autowired
    private RatingsRepository repository;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        repository.save(new Rating(1, "Klaus", "Good", 4));
        repository.save(new Rating(1, "Mimi", "No comment", 1));
        repository.save(new Rating(1, "Vava", "Mega schoen!", 5));
        repository.save(new Rating(3, "St02an", "Next year again", 5));
        repository.save(new Rating(1, "Anton", "Great, but not perfect", 4));
    }
}
