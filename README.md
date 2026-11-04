# SAP SuccessFactors Employee Master Data Integration

An end-to-end integration project built using **SAP Integration Suite (Cloud Integration / CPI)**, SAP SuccessFactors OData V2, FastAPI, and PostgreSQL.

The project demonstrates how employee master data can be retrieved from SAP SuccessFactors, transformed, and synchronized with an external application through a secured REST API.

## Project Architecture

```text
Postman
   |
   | HTTPS GET + employeeId
   v
SAP Integration Suite (CPI)
   |
   |-- Extract and validate Employee ID
   |
   |-- Router: Missing Employee ID?
   |       |
   |       +-- Yes --> Return validation response
   |       |
   |       +-- No
   |            |
   |            v
   |       SuccessFactors OData V2
   |            |
   |            v
   |       Router: Employee Found?
   |            |
   |            +-- No --> Return NOT_FOUND response
   |            |
   |            +-- Yes
   |                 |
   |                 v
   |          Extract employee fields
   |                 |
   |                 v
   |          Transform XML to JSON
   |                 |
   |                 v
   |          Retrieve API key from
   |          SAP BTP Security Material
   |                 |
   |                 v
   |          HTTP POST to FastAPI
   |                 |
   |                 v
   |          PostgreSQL Database
