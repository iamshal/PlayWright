# CI/CD Setup for Playwright Tests

## GitHub Actions Workflows

### 1. Standard CI Pipeline (`.github/workflows/ci.yml`)
- Runs tests directly on Ubuntu runner
- Uses Maven with Java 17
- Generates Allure reports
- Uploads test artifacts

### 2. Docker CI Pipeline (`.github/workflows/docker-ci.yml`)
- Builds Docker image
- Runs tests in containerized environment
- Generates Allure reports from Docker results

## Local Docker Testing

### Run tests with Docker Compose:
```bash
docker-compose up --build
```

### Run tests with Docker directly:
```bash
# Build image
docker build -t playwright-tests .

# Run tests
docker run --rm -v $(pwd)/target:/app/target playwright-tests
```

## Features

- **Automated Testing**: Tests run on every push and PR
- **Docker Support**: Containerized test execution
- **Allure Reporting**: Detailed test reports with screenshots
- **Artifact Upload**: Test results and reports are saved
- **Multi-Environment**: Both direct and Docker execution paths

## Workflow Triggers

- Push to `main` or `develop` branches
- Pull requests to `main` branch
- Manual workflow dispatch
