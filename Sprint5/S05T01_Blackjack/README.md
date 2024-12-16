Blackjack Game API
Description
This project implements a Java API using Spring Boot for a Blackjack game. The API is designed to connect to and manage information in two distinct databases: MongoDB and MySQL. The Blackjack game will include all the necessary functionalities, such as player management, card hands, and game rules.

The application will be properly tested and documented using tools like Swagger for API documentation and unit tests for controllers and services.

Features
Level 1: Basic Implementation
Reactive Application Development with Spring WebFlux:

A fully reactive application utilizing Spring WebFlux.
Reactive controllers and services for a non-blocking API.
Global Exception Handling:

A GlobalExceptionHandler is implemented to handle exceptions globally across the application.
Database Configuration:

Configured to use two databases: MongoDB (for reactive operations) and MySQL (for relational data storage).
Unit Testing:

Unit tests are implemented using JUnit and Mockito for at least one controller and one service.
Swagger Documentation:

Swagger is integrated to generate automatic API documentation.
API Endpoints
1. Create Game
   Method: POST
   Description: Create a new Blackjack game session.
   Endpoint: /game/new
   Request Body: New player name.
   Response:
   201 Created: Information about the created game.
2. Get Game Details
   Method: GET
   Description: Get details of a specific Blackjack game session.
   Endpoint: /game/{id}
   Parameters: Game ID (id)
   Response:
   200 OK: Detailed information about the game.
3. Make a Move
   Method: POST
   Description: Make a move in an existing Blackjack game session.
   Endpoint: /game/{id}/play
   Parameters:
   Game ID (id)
   Move details (e.g., type of move, amount wagered)
   Response:
   200 OK: The result of the move and current game status.
4. Delete Game
   Method: DELETE
   Description: Delete an existing Blackjack game session.
   Endpoint: /game/{id}/delete
   Parameters: Game ID (id)
   Response:
   204 No Content: Successfully deleted the game.
5. Get Player Ranking
   Method: GET
   Description: Get the ranking of players based on their performance in Blackjack games.
   Endpoint: /ranking
   Response:
   200 OK: List of players ranked by their score.
6. Change Player Name
   Method: PUT
   Description: Change the name of a player in an existing Blackjack game session.
   Endpoint: /player/{playerId}
   Request Body: New player name.
   Parameters: Player ID (playerId)
   Response:
   200 OK: Updated player information.
   Database Configuration
   MySQL
   MySQL is used to store the relational data, such as the game sessions and player data.
   Configure MySQL connection in application.properties.
   MongoDB
   MongoDB is used for reactive data handling, particularly for storing real-time game actions.
   Configure MongoDB connection in application.properties.
   Testing
   Unit tests are implemented for the following components:

Controllers: Test the API endpoints to ensure correct HTTP responses.
Services: Test the game logic and database interactions.
Test frameworks used:

JUnit: For writing unit tests.
Mockito: For mocking dependencies and testing service methods.
Swagger Documentation
Swagger is used to auto-generate API documentation, which can be accessed at:
