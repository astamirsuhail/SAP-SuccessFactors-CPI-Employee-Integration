
# FastAPI Target Application

## Purpose

This application acts as the target REST API for the SAP SuccessFactors integration.

SAP Integration Suite sends employee data to the application through an HTTP POST request.

## Technology

- Python
- FastAPI
- PostgreSQL
- SQLAlchemy / database integration (confirm against the actual application source)

## API Operations

| Method | Endpoint | Purpose |
|---|---|---|
| GET | /employees | Retrieve employee records |
| GET | /employees/{person_id_external} | Retrieve an individual employee |
| POST | /employees | Create or update an employee record |

## Authentication

The POST endpoint uses an API key supplied through the X-API-Key HTTP header.

The API key is maintained outside the source code in environment configuration and SAP BTP Security Material.

## Data Flow

1. FastAPI receives the JSON payload from CPI.
2. The application validates the request.
3. The application creates or updates the employee record.
4. PostgreSQL stores the employee information.
5. The API returns its response.

## Source Code

The actual sanitized FastAPI source files will be added to this folder separately.
