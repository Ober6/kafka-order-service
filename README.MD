# Order-Service

## Overview

Order-Service is a Spring Boot microservice that provides a single HTTP endpoint for creating orders. Upon receiving a request, the service generates a unique order ID, copies the received information, and sends it to a Kafka topic.

The project includes a `docker-compose.yml` file. To start Kafka, run the following command:

```bash
docker-compose up -d
```

## Load Testing

To simulate load on the HTTP endpoint, run the script:

```bash
bash http/http_load_test.sh
```

This script uses Apache Bench (ab) to send 100 requests with 10 parallel threads.

## Testing a Single Request

To send a single request, open the `save-order.http` file in your IDE and run the request, or use the following command:

```bash
curl -X POST -H "Content-Type: application/json" \
  -d '{"orderId": "12345", "product": "product-name", "quantity": 10}' \
  http://localhost:8080/orders
```

---

## Dependencies and Installation of Required Tools

### Docker & Docker Compose

- **Linux**: [Installation Guide](https://docs.docker.com/engine/install/)
- **macOS**: [Docker Desktop for Mac](https://docs.docker.com/desktop/mac/install/)
- **Windows**: [Docker Desktop for Windows](https://docs.docker.com/desktop/windows/install/)

For Linux Docker Compose: [Installation Guide](https://docs.docker.com/compose/install/)

### Apache Bench (ab)

Apache Bench is used for load testing the HTTP endpoint.

**Linux (Ubuntu/Debian):**

```bash
sudo apt update
sudo apt install apache2-utils
```

**macOS:**

Install with Homebrew:

```bash
brew install apache2
```

**Windows:**

Use the [Apache HTTP Server build](https://www.apachelounge.com/download/), which includes the `ab` utility.

Alternatively, use the Windows Subsystem for Linux (WSL) and install `apache2-utils` the same way as on Linux.