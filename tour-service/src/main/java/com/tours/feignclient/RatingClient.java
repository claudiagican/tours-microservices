package com.tours.feignclient;

import com.tours.response.RatingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * FeignClient interface describes the connection to the external service and the endpoint to address.
 * */
@FeignClient(name = "rating-service", url = "http://localhost:8081", path = "/rating-service")
public interface RatingClient {

    @GetMapping("/ratings/tours/tourId/{tourId}")
    public List<RatingResponse> getRatingsByTourId(@PathVariable("tourId") Integer tourId);

}
