# Music Streaming Service

This project implements a simplified version of a music streaming service in Java using Spring Boot. It includes an API to retrieve the top 100 trending songs based on various metrics such as play count, user ratings, social media shares, and recency of play.

## Table of Contents
- [Setup](#setup)
  - [Prerequisites](#prerequisites)
  - [Maven](#maven)
  - [Redis](#redis)
- [Running the Project](#running-the-project)
- [Testing](#testing)
- [Design](#design)
  - [Entities](#entities)
  - [Service Layer](#service-layer)
  - [Controller Layer](#controller-layer)
  - [Caching](#caching)

## Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven 3.6 or higher
- Docker (for running Redis in a container)

### Maven

Ensure Maven is installed and properly configured. To check your Maven installation, run:

```sh
mvn -version
```

If Maven is not installed, you can download it from the [Maven website](https://maven.apache.org/install.html) and follow the installation instructions.

### Redis

To run Redis in a Docker container:

1. Pull the Redis Docker image:

    ```sh
    docker pull redis
    ```

2. Run the Redis container:

    ```sh
    docker run --name redis-container -d -p 6379:6379 redis
    ```

To check if the Redis container is running:

```sh
docker ps
```


## Running the Project

1. **Clone the Repository**:

    ```sh
    git clone <repository-url>
    cd <repository-directory>
    ```

2. **Build the Project**:

    ```sh
    mvn clean install
    ```

3. **Run the Application**:

    ```sh
    mvn spring-boot:run
    ```

The application will start and listen on `http://localhost:8080`.

## Testing

You can use tools like `curl` or Postman to test the API endpoint.

1. **Retrieve Top 100 Trending Songs**:

    ```sh
    curl -X GET http://localhost:8080/api/trending-songs
    ```

1. **Retrieve Top 100 Trending Songs of Genre**:

    ```sh
    curl -X GET http://localhost:8080/api/trending-songs?genre=Genre1
    ```

### Example `application.properties`

Ensure your `src/main/resources/application.properties` file contains the following configuration for Redis:

```properties
spring.redis.host=localhost
spring.redis.port=6379
```


## Conclusion

This project demonstrates a basic implementation of a music streaming service using Spring Boot. It includes functionalities to calculate and retrieve trending songs based on multiple metrics, utilizing Redis for caching to enhance performance.
