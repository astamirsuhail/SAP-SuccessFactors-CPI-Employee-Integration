# CPI Integration Flow

## Integration Flow Name

Employee Master Data Integration

## Integration Flow ID

SF_EMPLOYEE_MASTER_DATA_IFLOW

## Processing Steps

### Step 1 – HTTPS Sender

Receives the incoming request from Postman.

Example request pattern:

GET /http/employee/masterdata?employeeId=<EMPLOYEE_ID>

### Step 2 – Content Modifier 1

Prepares initial message properties and headers as required by the flow.

### Step 3 – ExtractEmployeeID

A Groovy script reads the CamelHttpQuery header, extracts the employeeId parameter, and stores it in the EmployeeID exchange property.

It also sets InputValidationError to true or false.

### Step 4 – Router 2: Input Validation

Checks whether an employee ID was provided.

- Missing ID: routes to the validation response.
- Valid input: continues to the SuccessFactors request.

### Step 5 – Request Reply 1

Calls the SuccessFactors OData V2 service and waits for the response.

### Step 6 – Router 1: Employee Found

Checks the SuccessFactors response.

- Employee found: continues to data preparation.
- Employee not found: returns a NOT_FOUND response.

### Step 7 – Prepare Employee Data

Uses a Content Modifier to extract employee fields from the XML response and prepare the JSON body required by FastAPI.

### Step 8 – RetrieveFastAPIKey

A Groovy script retrieves the Secure Parameter named FASTAPI_API_KEY from SAP BTP Security Material and sets the X-API-Key request header.

The actual secret is not stored in the script.

### Step 9 – Send Employee to FastAPI

The HTTP Receiver Adapter sends the JSON payload to the FastAPI employee endpoint using POST.

### Step 10 – Database Persistence

FastAPI validates and processes the request, then creates or updates the employee record in PostgreSQL.

## Error and Validation Scenarios

- Missing employee ID is handled before the SuccessFactors call.
- Unknown employee ID is handled through employee-not-found routing.
- Errors from external services can be investigated using CPI monitoring and message processing logs.
