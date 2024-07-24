#### Detailed Design and Architecture
**1. Architecture Overview**

The Music Streaming Service is designed to be a highly scalable and performant system to manage and retrieve trending songs data. The system leverages Spring Boot for building the RESTful API, Redis for caching, and a relational database (such as MySQL) for persistent storage.

**2. Components**

- **Controller Layer**: Handles incoming HTTP requests and routes them to the appropriate service methods.
- **Service Layer**: Contains business logic for retrieving and calculating trending songs.
- **Repository Layer**: Interfaces with the database to perform CRUD operations.
- **Database**: The project uses H2 InMemory database (can be replaced with a traditional SQL DB with config changes), for faster testing purposes.
- **Cache Layer**: Uses Redis to cache the results of frequently accessed data to improve performance.




**3. Database Design**

- **Songs Table**: To store the static details of a song
    - `id` (Long): Primary key
    - `title` (String): Title of the song
    - `artist` (String): Artist of the song
    - `album` (String): Album name
    - `genre` (String): Genre of the song

- **SongStats Table**: To store the dynamic details of a song
    - `id` (Long): Primary key
    - `playCount` (Integer): Number of times the song has been played
    - `userRating` (Double): Average user rating of the song
    - `socialMediaShares` (Integer): Number of times the song has been shared on social media
    - `geographicPopularity` (String): Region where the song is popular
    - `lastPlayed` (Date): Timestamp of the last time the song was played
    - `songId` (Long): Foreign key linking to the `Songs` table

**4. Caching Strategy**

- **Top Trending Songs Cache**: Results of the top 100 trending songs are cached using Redis to minimize database load and improve response time.
- **Genre-Specific Trending Songs Cache**: Results of the top trending songs filtered by genre are also cached using Redis.

**5. Performance Considerations**

- **Caching**: The use of Redis for caching significantly reduces the load on the database and ensures fast retrieval of trending songs.
- **Batch Processing**: Trending scores are calculated in batch processes to optimize performance.
- **Database Indexing**: Proper indexing on relevant columns (`playCount`, `userRating`, etc.) in the database ensures efficient querying.