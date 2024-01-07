package com.ratings.repository;

import com.ratings.domain.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Rating repository
 * */
@Repository
public interface RatingsRepository extends CrudRepository<Rating, Integer> {

    /**
     * Loads a list of ratings with for a given tourId
     * @param tourId id of a touristic tour
     * @return @{@link Rating} list
     */
    @Query("select r from Rating r where r.tourId = ?1")
    public List<Rating> findByTourId(Integer tourId);

}
