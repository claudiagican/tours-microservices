Microservices demo communication using FeignClient.

Touristic tours service: http://localhost:8080/tour-service

Rating service: http://localhost:8081/rating-service

The call to 

    /tour-service/tours/{id}/ratings 

will internally use the Feign client to fetch data from 

    /rating-service/ratings/tours/tourId/{tourId}