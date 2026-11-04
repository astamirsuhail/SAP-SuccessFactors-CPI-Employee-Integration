# Solution Architecture

## 1. Architecture Overview

The solution uses SAP Integration Suite as middleware between SAP SuccessFactors and an external FastAPI application.

Postman is used as the client to invoke the CPI HTTPS endpoint.

## 2. High-Level Data Flow

1. Postman sends an HTTPS GET request with an employeeId query parameter.
2. CPI receives the request through the HTTPS Sender Adapter.
3. A Groovy script extracts the employee ID from the incoming HTTP query.
4. A Router checks whether the employee ID is missing.
5. If missing, the flow returns an input validation response.
6. If present, CPI calls SuccessFactors using the OData V2 receiver adapter.
7. A second Router determines whether the employee record was found.
8. If no record is found, CPI returns a NOT_FOUND response.
9. If found, a Content Modifier extracts the required employee fields and prepares a JSON payload.
10. A Groovy script retrieves the FastAPI API key from SAP BTP Security Material.
11. CPI sends the JSON payload to FastAPI using HTTP POST.
12. FastAPI processes the request and persists the employee record in PostgreSQL.

## 3. Data Mapping

| SuccessFactors field | Target JSON field |
|---|---|
| personIdExternal | person_id_external |
| personalInfoNav/firstName | first_name |
| personalInfoNav/lastName | last_name |
| employmentNav/userId | user_id |
| employmentNav/startDate | start_date |
| employmentNav/endDate | end_date |

The SuccessFactors response is XML. CPI extracts the required values and constructs the JSON payload expected by FastAPI.

## 4. Security

The FastAPI API key is stored as a Secure Parameter in SAP BTP Security Material.

The integration flow retrieves the parameter at runtime and uses it in the outbound HTTP request header.

The actual API key is intentionally excluded from this repository.

## 5. Integration Pattern

The project demonstrates a synchronous inbound HTTPS request followed by an outbound SuccessFactors request and an HTTP POST to the target application.

The integration is orchestrated through SAP Cloud Integration.
