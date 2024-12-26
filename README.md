# E-commerce Backend Application

Overview
This is a simplified e-commerce backend application built using Java Spring Boot. It provides functionality for user authentication, product management, real-time price updates via WebSockets, and purchase simulation.

Technical Requirements
- Java 11+
- Spring Boot 2.5+
- In-memory database (H2)
- JWT-based authentication
- WebSocket for real-time price updates

Setup Instructions
1. Clone the repository: git clone (link unavailable)
2. Build the project: mvn clean package
3. Run the application: java -jar target/Ecommerce_Application-0.0.1-SNAPSHOT.jar
4. Access the API documentation: http://localhost:8080/swagger-ui/

API Documentation
User Authentication
- POST /api/signup - Register a new user
- POST /api/signin - Login an existing user
- POST /api/refresh - Refresh access token

Product Management
- POST /api/products - Create a new product
- GET /api/products - List all products

Real-Time Pricing
- WebSocket endpoint: /ws/product-price/{product_id}

Purchase Simulation
- POST /api/buy/{product_id} - Simulate purchasing a product

Deployment Instructions
1. Build the Docker image: docker build -t ecommerceapp .
2. Run the Docker container: docker run -p 8080:8080 ecommerceapp

