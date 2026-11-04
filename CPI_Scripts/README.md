# CPI Groovy Scripts

This directory contains the Groovy scripts used by the SAP Integration Suite iFlow.

## `ExtractEmployeeID.groovy`
Extracts the `employeeId` supplied by the inbound HTTPS request and makes the value available to subsequent iFlow steps through an exchange property. It supports dynamic requests and identifies missing input for validation.

## `RetrieveFastAPIKey.groovy`
Retrieves the FastAPI API key from SAP Integration Suite Security Material at runtime. It reads the configured secure-parameter alias, accesses the Secure Store service and sets the `X-API-Key` header for the outbound request.

## Security
Never place actual API keys, passwords, tokens or private endpoints in these scripts. Do not publish runtime traces containing authentication headers.
