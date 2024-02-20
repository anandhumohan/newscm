# Product Service

## Overview

Product Service is a microservice designed for the Supply Chain Management ecosystem, focusing on managing product information, inventory levels, and product lifecycle within the supply chain. Built with Spring Boot, it offers a robust set of APIs that facilitate seamless integration with other microservices such as Order Management, Warehouse Management, and Distribution.

## Features

- **Product Information Management**: CRUD operations for managing product details.
- **Inventory Tracking**: Real-time inventory level monitoring and updates.
- **Product Lifecycle Management**: Track and manage the stages of a product's lifecycle from creation to discontinuation.
- **Integration Points**: Seamless connectivity with other supply chain microservices for synchronized operations.

## Getting Started

### Prerequisites

- JDK 11 or later
- Maven 3.6 or later
- Docker (optional for containerization)
- An instance of MySQL or any compatible database

### Setup

1. **Clone the repository**:

```bash
git clone https://github.com/yourorganization/product-service.git
cd product-service
```

2. **Configure application properties**:

Navigate to `src/main/resources/application.properties` and configure your database settings:

```properties
spring.datasource.url= YourDatabaseURL
spring.datasource.username= YourDBUsername
spring.datasource.password= YourDBPassword
```

3. **Build the application**:

```bash
mvn clean install
```

4. **Run the application**:

```bash
java -jar target/product-service-0.0.1-SNAPSHOT.jar
```

Alternatively, if you're using Docker:

```bash
docker build -t product-service .
docker run -p 8080:8080 product-service
```

### API Documentation

After starting the application, access the Swagger UI for API documentation and testing at `http://localhost:8080/swagger-ui.html`.

## Usage

Examples of common API requests:

- **Add a new product**:

```bash
curl -X POST http://localhost:8080/api/products -H 'Content-Type: application/json' -d '{
  "name": "New Product",
  "description": "Product Description",
  "price": 9.99,
  "inventoryCount": 100
}'
```

- **Get product by ID**:

```bash
curl http://localhost:8080/api/products/{productId}
```

## Contributing

We welcome contributions to the Product Service! Please read our [Contributing Guide](CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests to us.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE) file for details.

## Contact

For any queries or further assistance, please contact [support@yourorganization.com](mailto:support@yourorganization.com).
