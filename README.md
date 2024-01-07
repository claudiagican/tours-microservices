Spring Boot Microservices demo communication using FeignClient.

Touristic tours service: http://localhost:8080/tour-service

Rating service: http://localhost:8081/rating-service

The call to 

    /tour-service/tours/{id}/ratings 

will internally use the Feign client to fetch data from 

    /rating-service/ratings/tours/tourId/{tourId}

Response for request: http://localhost:8080/tour-service/tours/1/ratings
````
{
    "title": "Nordic Lights",
    "offer": "guided hikes through surrounding national parks, picnic lunches",
    "price": 1500,
    "duration": "3 days",
    "difficulty": "Medium",
    "ratingResponse": [
        {
            "tourId": 1,
            "authorName": "Klaus",
            "comment": "Good",
            "score": 4
        },
        {
            "tourId": 1,
            "authorName": "Mimi",
            "comment": "No comment",
            "score": 1
        },
        {
            "tourId": 1,
            "authorName": "Vava",
            "comment": "Mega schoen!",
            "score": 5
        },
        {
            "tourId": 1,
            "authorName": "Anton",
            "comment": "Great, but not perfect",
            "score": 4
        }
    ]
}
````