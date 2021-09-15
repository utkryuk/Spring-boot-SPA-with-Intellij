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

* docker
* docker-compose

### Installation

1. Clone the repo
    ```sh
    git clone https://github.com/utkryuk/Spring-boot-SPA-with-Intellij.git
    ```
2. To build docker image of frontend
    ```sh
    cd frontend/
    docker build -t phonebook-frontend .
    ```
3. To build docker image of backend
   ```sh
   cd backend/
   docker build -t phonebook-backend .
   ```
4. To run the application
   ```sh
   docker-compose up
   ```
5. To stop the application
   ```sh
   docker-compose down
   ```