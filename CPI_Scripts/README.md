# CPI Groovy Scripts

This folder contains the Groovy scripts used in the SAP Integration Suite integration flow.

## 1. ExtractEmployeeID.groovy

Purpose:
- Reads the incoming HTTP query string.
- Extracts the employeeId parameter.
- Stores the value in the EmployeeID exchange property.
- Sets InputValidationError based on whether the parameter is available.

## 2. RetrieveFastAPIKey.groovy

Purpose:
- Reads the secure parameter alias from the exchange property ApiKeyAlias.
- Retrieves the API key from SAP BTP Security Material.
- Sets the X-API-Key header for the FastAPI receiver request.

## Security

Actual API keys, passwords and credentials must never be stored in these source files.
