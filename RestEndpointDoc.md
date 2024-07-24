#### RESTful API Endpoints

**1. Retrieve Top 100 Trending Songs**

- **Endpoint**: `/api/trending-songs`
- **Method**: `GET`
- **Description**: Retrieves the top 100 trending songs based on play count, user rating, social media shares, and geographic popularity.
- **Response**: Returns a JSON array of the top 100 trending songs.
- **Sample Response**:
  ```json
  [
      {
          "id": 1,
          "title": "Song Title 1",
          "artist": "Artist 1",
          "album": "Album 1",
          "genre": "Genre 1"
      },
      {
          "id": 2,
          "title": "Song Title 2",
          "artist": "Artist 2",
          "album": "Album 2",
          "genre": "Genre 2"
      }
      // ... up to 100 songs
  ]
  ```

**2. Retrieve Top Trending Songs by Genre**

- **Endpoint**: `/api/trending-songs?genre=Genre1`
- **Method**: `GET`
- **Description**: Retrieves the top trending songs filtered by a specific genre.
- **Query Parameters**:
    - `genre` (string): The genre to filter songs by.
- **Response**: Returns a JSON array of the top trending songs for the specified genre.
- **Sample Response**:
  ```json
  [
      {
          "id": 1,
          "title": "Song Title 1",
          "artist": "Artist 1",
          "album": "Album 1",
          "genre": "Genre1"
      },
      {
          "id": 2,
          "title": "Song Title 2",
          "artist": "Artist 2",
          "album": "Album 2",
          "genre": "Genre1"
      }
      // ... top 100 trending songs in the specified genre
  ]
  ```