# FastAPI Target Application

## Purpose
FastAPI is the target REST service called by the SAP Integration Suite iFlow. It accepts normalized employee JSON, validates the request and persists employee data in PostgreSQL.

## API operations
| Method | Endpoint | Purpose |
|---|---|---|
| `GET` | `/employees` | Retrieve employee records |
| `GET` | `/employees/{person_id_external}` | Retrieve one employee by external person ID |
| `POST` | `/employees` | Create or update an employee record |

The running application's OpenAPI specification is the source of truth for exact schemas and response codes.

## Example POST body
```json
{
  "person_id_external": "EMPLOYEE_1001",
  "first_name": "Alex",
  "last_name": "Morgan",
  "user_id": "EMPLOYEE_1001",
  "start_date": "2025-01-15",
  "end_date": null
}
```
The example uses fictitious data.

## Authentication
The POST endpoint expects an API key in the `X-API-Key` header. The key is configured outside the source code and retrieved by CPI from Security Material. Never publish the key or a `.env` file containing secrets.

## Database
The application connects to PostgreSQL and writes to `public.employees`. Database connection parameters must be supplied through environment-specific configuration.

## API exploration
FastAPI exposes interactive API documentation through Swagger UI, normally at `/docs` while the application is running. Use it in an authorized local or development environment. Do not publish temporary tunnel URLs or credentials.

## Configuration
Provide database host, port, database name, username, password and expected API key through secure local environment configuration. Commit only placeholder examples.
