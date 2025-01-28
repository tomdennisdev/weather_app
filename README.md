
RESTful Weather Application (Java)

--

Overview

A full-stack RESTful weather app with client-server architecture. The system utilises APIs to fetch real-time weather data, integrates external APIs for location-based forecasts, and features a responsive GUI for user interaction and collaboration.

---

Features

- Weather Updates: Retrieve real-time weather data for any location.
- Trip Planning: Propose new trips, view current trips, and plan trips based on availablity and weather data.
- User Management: Store and retrieve user data for personalized experiences.
- Interactive GUI: A graphical interface for navigation between weather data, trip planning, and user options.

---

Project Structure

Weather_app/
│
├── src/
│   ├── clientApplication/          # Backend logic for API requests and data handling
│   │   ├── GetRequestClient.java   # Handles GET requests for fetching data
│   │   ├── PostRequestClient.java  # Handles POST requests for creating resources
│   │   ├── Weather.java            # Model class for weather data
│   │   ├── Trip.java               # Model class for trip data
│   │   └── ...
│   ├── GUI_windows/                # GUI implementation using Java Swing
│   │   ├── Login.java              # GUI for user login
│   │   ├── MainMenu.java           # Main menu of the application
│   │   ├── ProposeNewTrip.java     # GUI for creating new trips
│   │   └── ...
│
├── README.md                       # Documentation for the project
└── .gitignore                      # Git ignore file

---

Technologies Used

- Java: Primary programming language for backend and GUI.
- Java Swing: For designing and implementing the graphical user interface.
- REST API: For weather data retrieval and other backend operations.
