# snakegameusermanagement
# Snake Game with User Management

This is a Java-based Snake Game that integrates user login, registration, and high-score tracking.
SnakeGameUserManagement/
│
├── src/
│   ├── User.java
│   ├── UserManager.java
│   ├── SnakeGame.java
│   ├── GUVIProject.java
│
└── README.md


## Features
- User login and registration.
- High-score tracking per user.
- Classic Snake game mechanics with increasing difficulty.
The Snake Game is a classic arcade game reimagined with modern web technologies. As part of our group project, We developed the interactive Snake Game using HTML5, CSS3, and JavaScript. This version of the game features a clean and responsive design, a smooth user experience, and is integrated with a user management system to track scores.
Key Features:
Game Mechanics: The snake moves across a grid, growing longer as it consumes food items. The goal is to avoid colliding with the walls or the snake itself, while aiming to achieve the highest possible score.

Responsive Layout: Designed with Bootstrap, the game interface adapts seamlessly to different screen sizes, ensuring an optimal experience on mobile, tablet, and desktop devices.

User Registration and Login: Users can create an account, log in, and track their high scores. This allows users to see their progress over time and ensures a personalized gaming experience
The Snake Game with User Management project combines a simple Snake game with a user login/registration system to create an engaging and personalized gaming experience. Here's an explanation of its features and functionality:

Features
1. User Management System
This system enables users to register, log in, and maintain their gaming profile:

Registration:

Users can create an account by providing a unique username and password.
Ensures usernames are unique, preventing duplicate registrations.
Stores user data (username, password, and high score) in a file for persistence.
Login:

Existing users can log in by providing valid credentials.
Authenticates users by verifying their username and password.
High Score Tracking:

Each user has a personal high score.
If a player achieves a new high score during the game, it is automatically updated in their profile.
2. Snake Game
A classic implementation of the Snake game with basic mechanics:

Gameplay Mechanics:

Control the snake using arrow keys (↑, ↓, ←, →).
Eat the red apples to grow the snake and increase the score.
Avoid collisions with the walls or the snake's own body to keep the game running.
Score Tracking:

A live score is displayed during the game.
If the user’s score surpasses their previous high score, the system updates it automatically.
End of Game:

Displays the user’s final score when the game ends.
Informs the player if they've achieved a new high score.
3. Integration of User Profiles with the Game
Each player’s session is tied to their user profile.
The game records and saves the user’s progress persistently between sessions.
Only logged-in users can play the game, ensuring personalized gameplay.
How It Works
Launch the Application:

Run the program to access the main menu, which offers three options:
Login
Register
Exit
User Registration:

New users can register by providing a unique username and password.
The system confirms successful registration or notifies users if the username is already taken.
User Login:

Existing users log in with their credentials.
Upon successful login, the Snake game starts.
Play the Game:

Control the snake to eat apples, grow longer, and score points.
Avoid collisions to keep playing.
End of Game:

Displays the final score.
If the score is higher than the current user’s high score, it is updated automatically.
Exit the Application:

Users can exit the program at any point.
All user data, including scores, are saved persistently in a file.
Technical Highlights
User Data Storage:

User data is stored in a file (users.dat) using Java’s serialization.
The data is loaded at startup and saved when any updates are made.
Graphical Interface:

Uses Java Swing for the graphical interface.
The Snake game is displayed in a JPanel, and user interactions are handled with KeyListener and ActionListener.
Game Logic:

Apple positions are randomly generated within the game grid.
The snake’s movement, collision detection, and game over conditions are implemented in the SnakeGame class.
Modular Design:

The project is designed with separate classes for User, UserManager, and SnakeGame, ensuring clean and maintainable code.
Why Use This Project?
For Learning:

Combines multiple Java concepts like file handling, OOP (classes and objects), event-driven programming (key inputs), and GUI design.
Practical Application:

Demonstrates how to integrate a game with user management for personalized experiences.
Fun and Interactive:

Offers a nostalgic gaming experience while practicing programming.
Future Enhancements
If you want to improve or extend the project, here are some ideas:

Add a leaderboard to compare scores between users.
Enhance the game's visuals and animations.
Introduce multiple difficulty levels.
Migrate user data storage to a database for better scalability.


We have provided files in this repository!! 
From this we can develop a Snake game user management 
## How to Run
1. Clone the repository:
2. Compile and run:
3. Play and enjoy!

## Requirements
- Java 8 or above.
- Thankyou!!

