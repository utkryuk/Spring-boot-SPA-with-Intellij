# Springboot SPA with Intellij


## Built With:

* [Springboot](https://spring.io/projects/spring-boot)
* [Angular](https://angular.io/)
* [MongoDB](https://www.mongodb.com/)
* [Docker](https://www.docker.com/)


## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

You will need these preinstalled:

* npm
* docker
* docker-compose

### Installation

1. Clone the repo
    ```
    git clone https://github.com/utkryuk/Spring-boot-SPA-with-Intellij.git
    ```
2. To run backend with docker and docker-compose
   ```sh
   cd backend/phonebook/
   docker build -t phonebook-backend .
   cd ../..
   docker-compose up
   ```

3. To run frontend
    ```sh
    cd frontend/
    npm start
   ```
    - Go to http://localhost:4200/

4. To stop the backend application
   ```sh
   docker-compose down
   ```

## API Documentation

- After running the backend, the Swagger API documentation is hosted at: http://localhost:8081/swagger-ui.html