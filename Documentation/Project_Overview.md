# Project Overview

## SAP SuccessFactors Employee Master Data Integration

### Objective
Build an end-to-end integration using SAP Integration Suite (Cloud Integration/CPI) to retrieve employee master data from SAP SuccessFactors and synchronize it with an external FastAPI application backed by PostgreSQL.

### Key Features
- HTTPS-based integration endpoint.
- Dynamic employee ID extraction using Groovy.
- SAP SuccessFactors OData V2 integration.
- Employee-found and employee-not-found routing.
- XML-to-JSON transformation.
- Secure API key retrieval using SAP BTP Security Material.
- HTTP POST integration with FastAPI.
- PostgreSQL data persistence.

### Testing
The integration was tested with:
- Valid employee IDs.
- Invalid employee IDs.
- Missing employee IDs.
- Different dynamic employee IDs.
- Database verification after successful synchronization.

### Technology Stack
- SAP Integration Suite – Cloud Integration
- SAP SuccessFactors OData V2
- SAP BTP Security Material
- Groovy
- FastAPI
- Python
- PostgreSQL
- Postman
