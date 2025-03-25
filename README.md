# Scalable Tracking Number Generator API

## Overview
This is a Spring Boot-based RESTful API for generating unique tracking numbers for parcels. It is designed for scalability, efficiency, and high concurrency.

## Features
- Generates unique tracking numbers that match the regex pattern `^[A-Z0-9]{1,16}$`.
- Ensures no duplicate tracking numbers.
- Optimized for high concurrency.
- Designed to scale horizontally across multiple instances.

## API Specification
### Endpoint: `GET /next-tracking-number`
#### Query Parameters:
| Parameter           | Type   | Description |
|--------------------|--------|-------------|
| `origin_country_id` | String | ISO 3166-1 alpha-2 country code (e.g., "MY") |
| `destination_country_id` | String | ISO 3166-1 alpha-2 country code (e.g., "ID") |
| `weight` | String | Order weight in kilograms (e.g., "1.234") |
| `created_at` | String | Order creation timestamp in RFC 3339 format |
| `customer_id` | String | Customer UUID |
| `customer_name` | String | Customer's name |
| `customer_slug` | String | Customer name in kebab-case |

#### Example Request:
```
GET /next-tracking-number?origin_country_id=MY&destination_country_id=ID&weight=1.234&created_at=2023-03-24T12:00:00Z&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=RedBox%20Logistics&customer_slug=redbox-logistics
```

#### Example Response:
```json
{
  "tracking_number": "MYID1",
  "created_at": "2023-03-24T12:00:00Z"
}
```

## Setup Instructions
### Prerequisites
- Java 17+
- Maven

### Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/Sandeep0371/TrackingNumberApi.git
   cd TrackingNumberApi
   ```
2. Build the project:
   ```sh
   mvn clean install
   ```
3. Run the application:
   ```sh
   mvn spring-boot:run
   ```

### Running with Docker
1. Build the Docker image:
   ```sh
   docker build -t tracking-api .
   ```
2. Run the container:
   ```sh
   docker run -p 8080:8080 tracking-api
   ```

## Deployment
You can deploy the application on services like AWS, Heroku, or Google Cloud. Example using Google cloud:
create a Google Cloud account at Google Cloud
Download and install the Google Cloud SDK
gcloud auth login
gcloud config set project [YOUR_PROJECT_ID]
mvn spring-boot:run
mvn clean package
Create app.yaml file
gcloud app deploy
gcloud app browse



