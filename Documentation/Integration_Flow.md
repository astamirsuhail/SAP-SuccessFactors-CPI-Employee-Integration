# Integration Flow

## 1. Inbound request
The iFlow exposes an HTTPS endpoint. The caller supplies an employee ID as a query parameter.

```http
GET /http/employee/masterdata?employeeId=EMPLOYEE_1001
```

The runtime host is environment-specific and is intentionally not published here.

## 2. Extract employee ID
`ExtractEmployeeID` reads the incoming `employeeId` parameter and stores it in the `EmployeeID` exchange property for subsequent processing. This makes the request dynamic.

## 3. SuccessFactors lookup
CPI calls the SuccessFactors OData V2 `PerPerson` entity and expands the personal and employment navigation properties needed for the mapping. The query is scoped to the requested employee ID.

## 4. Conditional routing
After the source response is received, the router selects one of two paths.

### Employee found
1. Extract the required source fields.
2. Construct the normalized JSON body.
3. Retrieve the FastAPI key from CPI Security Material.
4. Set the `X-API-Key` request header.
5. Send an HTTP POST request to FastAPI.

### Employee not found
1. Create a structured not-found response.
2. End the not-found path without calling FastAPI.

## 5. Target request
The FastAPI request contains `Content-Type: application/json`, an `X-API-Key` header retrieved at runtime, and the normalized employee JSON body. The secret value is not documented here.

## 6. Persistence
FastAPI validates the request and writes the employee attributes to PostgreSQL table `public.employees`. The application implementation determines the exact create/update behavior.

## 7. Troubleshooting checkpoints
Inspect the inbound employee ID, SuccessFactors response, router branch, prepared JSON body, target HTTP response and resulting database row. Never publish credentials, tokens, API keys or real employee data in logs or screenshots.
