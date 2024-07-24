## Overview
The Technical Assignment Backend is a Spring Boot application that interacts with the Open Brewery DB API. It provides endpoints to fetch and search for breweries, with server-side validation to ensure data integrity. This backend is designed to support a frontend application that allows users to search and manage breweries.

## Features
- Fetch Breweries: Retrieve a list of breweries with pagination.
- Search Breweries: Search breweries by name, city, state, and type with filtering and pagination.
- Fetch Brewery by ID: Retrieve detailed information about a specific brewery by its ID.
- Validation: Server-side validation for search parameters to ensure correct data format.
  
## Technologies Used
- Spring Boot: Framework for building the backend application.
- Java: Programming language used for the application.
- Spring Data JPA: Data access layer for interacting with the Open Brewery DB API.
- Spring Validation: Library for validating input data.
  
## Prerequisites
Before you begin, ensure you have met the following requirements:

- Java JDK 17 or later
- Maven (for dependency management and building the project)
  
## Setup Instructions
- Clone the repository to your local machine.
- Build the project using Maven ($ mvn clean install).
- Start the Spring Boot application ($ mvn spring-boot:run)
- The application will be available at http://localhost:8080.
  
# API Endpoints
## Fetch Breweries
- Endpoint: GET /api/breweries
- Parameters:
- page (optional): Page number for pagination. Default is 1.
- perPage (optional): Number of items per page. Default is 10.
## Example Request:
GET http://localhost:8080/api/breweries?page=1&perPage=10
  
## Search Breweries
- Endpoint: GET /api/breweries/search
- Parameters:
- name (optional): Filter by brewery name.
- city (optional): Filter by city.
- state (optional): Filter by state.
- type (optional): Filter by brewery type.
- page (optional): Page number for pagination. Default is 1.
- perPage (optional): Number of items per page. Default is 10.
## Example Request:
GET http://localhost:8080/api/breweries/search?name=Ale&city=Denver&state=Colorado&type=Micro&page=1&perPage=10
  
## Fetch Brewery by ID
- Endpoint: GET /api/breweries/{id}
- Path Variable:
- id: The ID of the brewery to fetch.
## Example Request:
GET http://localhost:8080/api/breweries/123
# Validation
Server-side validation is applied to search parameters:

- Name: Should only contain letters, numbers, and spaces.
- City: Should only contain letters and spaces.
- State: Should only contain letters and spaces.
- Type: Should be a valid brewery type according to the API.
Invalid parameters will result in an empty array being returned.

# Additional Notes
Ensure that the API URL is correctly set in application.properties.
- openbrewerydb.api.url=https://api.openbrewerydb.org/breweries
