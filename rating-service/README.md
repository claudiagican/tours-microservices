Microservice built in Spring Boot with Spring Data Rest and JPA persistence (H2). 

Using JPA Query method.

Main endpoint:

http://localhost:8081/rating-service

Exposed endpoint:

http://localhost:8081/rating-service/ratings/tours/tourId/{tourId}

```
[
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
```


