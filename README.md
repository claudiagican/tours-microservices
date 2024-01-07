Spring Boot Microservices demo communication using FeignClient.

Touristic tours service: http://localhost:8080/tour-service

Rating service: http://localhost:8081/rating-service

The call to 

    /tour-service/tours/{id}/ratings 

will internally use the Feign client to fetch data from request 

    /rating-service/ratings/tours/tourId/{tourId}

The response for REST request: http://localhost:8080/tour-service/tours/1/ratings
includes "ratingResponse" section from rating-service among the data from the local repository:
````
{
    "title": "Nordic Lights",
    "offer": "guided hikes through surrounding national parks, picnic lunches",
    "price": 1500,
    "duration": "3 days",
    "difficulty": "Medium",
    "ratingResponse": [
        {
            "authorName": "Klaus",
            "comment": "Good",
            "score": 4
        },
        {
            "authorName": "Mimi",
            "comment": "No comment",
            "score": 1
        },
        {
            "authorName": "Vava",
            "comment": "Mega schoen!",
            "score": 5
        },
        {
            "authorName": "Anton",
            "comment": "Great, but not perfect",
            "score": 4
        }
    ]
}
````