
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

├── src/                    # Source code directory
│   ├── ClientApplication/  # Client-side application directory
│   │   ├── clientApplication/  # Contains the core logic of the client application
│   │   └── GUI_windows/        # Graphical User Interface components for Windows
│   │
│   ├── RESTService/        # Backend RESTful API service directory
│   │   └── java/               # Java source code for the RESTful API
│     
├── LICENSE                 # License details for the project
├── README.md               # Main project documentation
└── .gitignore              # Specifies files and directories to ignore in Git

---

Technologies Used

- Java: Primary programming language for backend and GUI.
- Java Swing: For designing and implementing the graphical user interface.
- REST API: For weather data retrieval and other backend operations.
