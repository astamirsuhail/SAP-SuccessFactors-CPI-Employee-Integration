# Architecture and Data Flow

```text
Postman -> CPI HTTPS Sender -> input validation/router
        -> SuccessFactors OData V2 Request Reply
        -> employee-found router
        -> XPath extraction / JSON construction
        -> secure API key retrieval
        -> HTTP POST -> FastAPI -> PostgreSQL
```

1. Postman sends an HTTPS GET request with `employeeId`.
2. `ExtractEmployeeID` reads `CamelHttpQuery` and sets the `EmployeeID` exchange property.
3. A router handles missing input.
4. CPI queries SuccessFactors OData V2 using `PerPerson` and selected navigation properties.
5. CPI routes the result to employee-found or employee-not-found processing.
6. The found branch extracts selected XML fields and constructs JSON.
7. CPI retrieves the API key using the Secure Parameter alias `FASTAPI_API_KEY`.
8. The HTTP receiver POSTs the payload to FastAPI.
9. FastAPI persists the record in PostgreSQL.

The original SuccessFactors identity/authentication and the API key used by CPI to call FastAPI are separate security contexts.
